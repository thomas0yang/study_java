package com.thomas.products.util;

import net.sf.json.JSONObject;
import org.apache.commons.lang.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangyang32 on 17/1/11.
 */
public class FormDataToJSONBak {


    public static void main(String[] args) {
        String formData =
                "querys[data][pageId]:53\n" +
                        "querys[data][indexes]:original_price,online_poi_num,txn_poi_num\n" +
                        "querys[data][filters][0][key]:dt_name\n" +
                        "querys[data][filters][0][values]:20170104`20170110\n" +
                        "querys[data][filters][1][key]:rate_type\n" +
                        "querys[data][filters][1][values]:1`2\n" +
                        "querys[data][filters][2][key]:org_id\n" +
                        "querys[data][filters][2][values]:2132\n" +
                        "querys[data][filters][2][level]:1\n" +
                        "querys[data][filters][2][type]:-999\n" +
                        "querys[data][filters][2][multi_flag]:0\n" +
                        "querys[data][filters][2][value][0][val]:2132\n" +
                        "querys[data][filters][2][value][0][type]:-999\n" +
                        "querys[data][filters][2][value][0][level]:1\n" +
                        "querys[data][filters][3][key]:poi_type_id\n" +
                        "querys[data][filters][3][values]:-1\n" +
                        "querys[data][filters][3][multi_flag]:0\n" +
                        "querys[data][filters][3][value][0][val]:-1\n" +
                        "querys[data][filters][3][value][0][level]:1\n" +
                        "querys[data][filters][4][key]:ord_time_seg_id\n" +
                        "querys[data][filters][4][values]:-1\n" +
                        "querys[data][filters][4][multi_flag]:0\n" +
                        "querys[data][filters][4][value][0][val]:-1\n" +
                        "querys[data][filters][4][value][0][level]:1\n" +
                        "querys[data][filters][5][key]:aor_type_id\n" +
                        "querys[data][filters][5][values]:-1\n" +
                        "querys[data][filters][5][multi_flag]:0\n" +
                        "querys[data][filters][5][value][0][val]:-1\n" +
                        "querys[data][filters][5][value][0][level]:1\n" +
                        "querys[data][filters][6][key]:is_new_poi_id\n" +
                        "querys[data][filters][6][values]:-1\n" +
                        "querys[data][filters][6][multi_flag]:0\n" +
                        "querys[data][filters][6][value][0][val]:-1\n" +
                        "querys[data][filters][6][value][0][level]:1\n" +
                        "querys[data][filters][7][key]:poi_dely_type_id\n" +
                        "querys[data][filters][7][values]:-1\n" +
                        "querys[data][filters][7][multi_flag]:0\n" +
                        "querys[data][filters][7][value][0][val]:-1\n" +
                        "querys[data][filters][7][value][0][level]:1\n" +
                        "querys[data][filters][8][key]:category_id\n" +
                        "querys[data][filters][8][values]:-1\n" +
                        "querys[data][filters][8][multi_flag]:0\n" +
                        "querys[data][filters][8][value][0][val]:-1\n" +
                        "querys[data][filters][8][value][0][level]:1\n" +
                        "querys[data][dims]:rate_type,org_id,poi_type_id,ord_time_seg_id,aor_type_id,is_new_poi_id,poi_dely_type_id,category_id,dt_name\n" +
                        "querys[data][pageFlag]:false\n" +
                        "querys[data][posId]:1";
        String covert = covert(formData);
        System.out.println(covert);
    }

    private static String covert(String formData) {
        Map json = new HashMap<>();
        String[] split = formData.split("\n");
        for (String line : split) {
            String[] split1 = line.split(":");
            List<String> index = findIndex(split1[0]);
            Object tmp = json;
            for (int i = 0; i < index.size(); i++) {
                String s1 = index.get(i);
                if (i == index.size() - 1) {
                    if (tmp instanceof List) {
                        Map map = new HashMap<>();
                        map.put(s1, split1[1]);
                        ((List) tmp).add(map);
                    } else {
                        ((Map) tmp).put(s1, split1[1]);
                    }
                } else {
                    if (tmp instanceof List) {
                        if (NumberUtils.isDigits(s1)) {
                            List<Map> list = new ArrayList<>();
                            Map objectObjectHashMap = new HashMap<>();
                            list.add(objectObjectHashMap);
                            ((List) tmp).add(list);
                            tmp = list;
                        } else {
                            Map map = new HashMap<>();
                            Map map2 = new HashMap<>();
                            map.put(s1, map2);
                            ((List) tmp).add(map);
                            tmp = map2;
                        }
                    } else {
                        Object o = ((Map) tmp).get(s1);
                        if (null == o) {
                            if (NumberUtils.isDigits(s1)) {
                                List<Map> list = new ArrayList<>();
                                Map objectObjectHashMap = new HashMap<>();
                                list.add(objectObjectHashMap);
                                tmp = list;
                            } else {
                                Map objectObjectHashMap = new HashMap<>();
                                ((Map) tmp).put(s1, objectObjectHashMap);
                                tmp = objectObjectHashMap;
                            }
                        } else {
                            if (o instanceof List) {
                                Map objectObjectHashMap = new HashMap<>();
                                ((List) o).add(objectObjectHashMap);
                                tmp = objectObjectHashMap;
                            } else {
                                tmp = o;
                            }
                        }
                    }
                }
            }
        }

        JSONObject jsonObject = JSONObject.fromObject(json);
        return jsonObject.toString();
    }

    private static Map put(Map json, String name) {
        Map re = new HashMap();
        json.putIfAbsent(name, re);
        return re;
    }


    private static Pattern pattern = Pattern.compile("\\[\\S*?\\]");

    private static List<String> findIndex(String ss) {
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(ss);
        while (matcher.find()) {
            String group = matcher.group();
            list.add(group.substring(1, group.length() - 1));
        }
        return list;
    }

}
