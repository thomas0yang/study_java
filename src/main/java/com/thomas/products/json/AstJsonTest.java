package com.thomas.products.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AstJsonTest {
    public static void main(String[] args) {

        String content =
                "{\n" +
                "    \"select\": [\n" +
                "        {\n" +
                "            \"title\": \"日期\",\n" +
                "            \"alias\": \"dt\",\n" +
                "            \"column\": \"t1.dt\",\n" +
                "            \"formula\": \"\",\n" +
                "            \"func\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"蜂窝\",\n" +
                "            \"alias\": \"\",\n" +
                "            \"column\": \"\",\n" +
                "            \"formula\": \"\",\n" +
                "            \"func\": {\n" +
                "                \"name\": \"when\",\n" +
                "                \"values\": [\n" +
                "                    {\n" +
                "                        \"op\": \">\",\n" +
                "                        \"values\": [\n" +
                "                            {\n" +
                "                                \"column\": \"t2.b\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"value\": \"0\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"column\": \"t1.c\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"value\": \"'1'\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"订单数\",\n" +
                "            \"alias\": \"ord_num\",\n" +
                "            \"column\": \"\",\n" +
                "            \"formula\": \"\",\n" +
                "            \"func\": {\n" +
                "                \"name\": \"sum\",\n" +
                "                \"values\": \"t2.ord_num\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"from\": [\n" +
                "        {\n" +
                "            \"alias\": \"t1\",\n" +
                "            \"type\": \"model\",\n" +
                "            \"model_id\": \"id1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"alias\": \"t2\",\n" +
                "            \"type\": \"table\",\n" +
                "            \"ds\": \"123\",\n" +
                "            \"db\": \"database_name\",\n" +
                "            \"table_name\": \"dimt_table\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"join\": [\n" +
                "        {\n" +
                "            \"join_type\": \"left\",\n" +
                "            \"on\": {\n" +
                "                \"op\": \"or\",\n" +
                "                \"values\": [\n" +
                "                    {\n" +
                "                        \"op\": \"=\",\n" +
                "                        \"values\": [\n" +
                "                            {\n" +
                "                                \"column\": \"t1.poi_id\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"column\": \"t2.poi_id\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"op\": \"=\",\n" +
                "                        \"values\": [\n" +
                "                            {\n" +
                "                                \"column\": \"t1.c\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"value\": \"'zhangsan'\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"where\": {\n" +
                "        \"op\": \"and\",\n" +
                "        \"values\": [\n" +
                "            {\n" +
                "                \"op\": \">=\",\n" +
                "                \"values\": [\n" +
                "                    {\n" +
                "                        \"column\": \"t1.dt\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"column\": \"'20161111'\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"op\": \"or\",\n" +
                "                \"values\": [\n" +
                "                    {\n" +
                "                        \"op\": \"or\",\n" +
                "                        \"values\": [\n" +
                "                            {\n" +
                "                                \"op\": \">\",\n" +
                "                                \"values\": [\n" +
                "                                    {\n" +
                "                                        \"op\": \"/\",\n" +
                "                                        \"values\": [\n" +
                "                                            {\n" +
                "                                                \"column\": \"t1.a\"\n" +
                "                                            },\n" +
                "                                            {\n" +
                "                                                \"column\": \"t2.b\"\n" +
                "                                            }\n" +
                "                                        ]\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"value\": \"3\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"op\": \"in\",\n" +
                "                                \"values\": [\n" +
                "                                    {\n" +
                "                                        \"value\": 1\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"value\": 2\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"value\": 3\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"group\": [\n" +
                "        {\n" +
                "            \"column\": \"t1.dt\",\n" +
                "            \"formula\": \"\",\n" +
                "            \"func\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"column\": \"\",\n" +
                "            \"formula\": \"\",\n" +
                "            \"func\": {\n" +
                "                \"name\": \"when\",\n" +
                "                \"values\": [\n" +
                "                    {\n" +
                "                        \"op\": \">\",\n" +
                "                        \"values\": [\n" +
                "                            {\n" +
                "                                \"column\": \"t2.b\"\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"value\": \"0\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"column\": \"t1.c\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"value\": \"'1'\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"order\": [\n" +
                "        {\n" +
                "            \"column_alias\": \"dt\",\n" +
                "            \"type\": \"asc\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"column_alias\": \"ord_num\",\n" +
                "            \"type\": \"desc\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"limit\": {\n" +
                "            \"from\": \"0\",\n" +
                "            \"size\": \"10\"\n" +
                "    }\n" +
                "}";

        JSONObject jsonObj = JSONObject.fromObject(content);

//        ASTNODE ast = (ASTNODE)JSONObject.toBean(jsonObj, ASTNODE.class);

        JSONArray array = (JSONArray) jsonObj.get("16");
        JSONObject jsonObj0 = (JSONObject) array.get(0);
        System.err.println(jsonObj0.get("id"));
        System.err.println(jsonObj0.get("name"));
        JSONObject jsonObj1 = (JSONObject) array.get(1);
        System.err.println(jsonObj1.get("id"));
        System.err.println(jsonObj1.get("name"));
        JSONObject jsonObj2 = (JSONObject) array.get(2);
        System.err.println(jsonObj2.get("id"));
        System.err.println(jsonObj2.get("name"));
    }

}

class ASTNODE{
    private Object select;
    private Object from;
    private Object join;
    private Object where;
    private Object group;
    private Object order;
    private Object limit;

    public Object getSelect() {
        return select;
    }

    public void setSelect(Object select) {
        this.select = select;
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    public Object getJoin() {
        return join;
    }

    public void setJoin(Object join) {
        this.join = join;
    }

    public Object getWhere() {
        return where;
    }

    public void setWhere(Object where) {
        this.where = where;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public Object getOrder() {
        return order;
    }

    public void setOrder(Object order) {
        this.order = order;
    }

    public Object getLimit() {
        return limit;
    }

    public void setLimit(Object limit) {
        this.limit = limit;
    }
}