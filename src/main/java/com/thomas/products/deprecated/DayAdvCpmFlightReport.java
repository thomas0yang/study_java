/**
 * Copyright (c) 2012 Sohu TV. All rights reserved.
 */

package com.thomas.products.deprecated;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Vector;
//import java.util.Map.Entry;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.sohu.tv.util.BaseSendMail;
//import com.sohu.tv.util.Constants;
//import com.sohu.tv.util.DBUtil;
//import com.sohu.tv.util.DateUtil;
//import com.sohu.tv.util.HTMLUtil;
//import com.sohu.tv.util.ProvinceCityManager;
//import com.sohu.tv.util.Util;
//
///**
// * 每天cpm和flight的统计
// * Author : Wanglei Date : 2012-11-9
// *
// */
//public class DayAdvCpmFlightReport {
//
//    private static class BeanStatAdvCpmFlightDay {
//
//        private String ccode;
//        private String cName;
//        private long cpm;
//        private long flight;
//
//        public String getCcode() {
//            return ccode;
//        }
//
//        public String getcName() {
//            return cName;
//        }
//
//        public long getCpm() {
//            return cpm;
//        }
//
//        public long getFlight() {
//            return flight;
//        }
//
//        public void setCcode(final String ccode) {
//            this.ccode = ccode;
//        }
//
//        public void setcName(final String cName) {
//            this.cName = cName;
//        }
//
//        public void setCpm(final long cpm) {
//            this.cpm = cpm;
//        }
//
//        public void setFlight(final long flight) {
//            this.flight = flight;
//        }
//    }
//    private static String[] ADDRESS1 = new String[] {
//    "yangyang200568@sohu-inc.com" };
//    private static String[] ADDRESS2 = new String[] {
//        "yangyang200568@sohu-inc.com", "leiwangbj9197@sohu-inc.com", "congli@sohu-inc.com" };
//    private static Date date = DateUtil.addDays(new Date(), -1);
//
//    private static String[] ERR_ADDRESS = new String[] {
//    "yangyang200568@sohu-inc.com" };
//
//    private static List<BeanStatAdvCpmFlightDay> resultList = new ArrayList<BeanStatAdvCpmFlightDay>();
//
//    private static String getCcode(final String citycode) {
//        if (citycode == null || "".equals(citycode)) {
//            return citycode;
//        }
//        if (citycode.startsWith("CN") && citycode.length() == 4) {
//            return citycode.substring(2, 4) + "0000";
//        }
//        if (citycode.startsWith("CN") && citycode.length() >= 4) {
//            return citycode.substring(2, 6) + "00";
//        }
//        return null;
//    }
//
//    private static double getRatio(final String ccode, final String detail) {
//        final Map<String, Double> parseDetial = parseDetial(detail);
//        double value = 0;
//        double all = 0;
//        for (final Entry<String, Double> iterable_element : parseDetial.entrySet()) {
//            if (ccode.equals(iterable_element.getKey())) {
//                value += iterable_element.getValue();
//            }
//            all += iterable_element.getValue();
//        }
//        return value / all;
//    }
//
//    /**
//     * 获取标题
//     * @return
//     */
//    private static String getTitile() {
//        return "TOP50城市CPM、Flight统计[" + DateUtil.dateToString(date) + "]";
//    }
//
//    public static void loadData() {
//
//        final String cpmSql = "select ccode,sum(stock) as cpm from stat_adv_stock where date='" + DateUtil.dateToString(date)
//        + "' and scope=1 and ts >0 GROUP BY ccode order by cpm desc limit 82";
//        System.out.println("cpmSql=" + cpmSql);
//        Connection con = null;
//        Statement st = null;
//        ResultSet rs = null;
//        try {
//            con = DBUtil.getConnection(Constants.MYSQL_DB_STAT_ONLINE);
//            st = con.createStatement();
//            rs = st.executeQuery(cpmSql);
//            while (rs.next()) {
//                final BeanStatAdvCpmFlightDay bean = new BeanStatAdvCpmFlightDay();
//                final String ccode = rs.getString("ccode");
//                bean.setCcode(ccode);
//                bean.setCpm(rs.getLong("cpm"));
//                if (ccode.length() == 4 && !ProvinceCityManager.getInstance().isZhiXiaShi(ccode)
//                        || "CN".equals(ccode)) {
//                    continue;
//                }
//                resultList.add(bean);
//                if (resultList.size() == 50) {
//                    break;
//                }
//            }
//        } catch (final Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closers(rs);
//            DBUtil.closeps(st);
//            DBUtil.close(con);
//        }
//
//
//        final Map<String, Long> flightMap = new HashMap<String, Long>();
//
//        final String flightSql = "SELECT areadirect,flightcpm,cpmdetail from t_book where bookdate='"
//            + DateUtil.dateToString(date) + "'  and areadirect !='' and status=0";
//        System.out.println("flightSql=" + flightSql);
//        try {
//            con = DBUtil.getConnection(Constants.MYSQL_DB_BACKEND);
//            st = con.createStatement();
//            rs = st.executeQuery(flightSql);
//            while (rs.next()) {
//                final String areadirect = rs.getString("areadirect");
//                final long flight = rs.getLong("flightcpm");
//                if (areadirect.contains(",")) {
//                    final String cpmdetail = rs.getString("cpmdetail");
//                    String cpmdetailSub = null;
//                    if (null != cpmdetail && !"".equals(cpmdetail)) {
//                        cpmdetailSub = cpmdetail.substring(7, cpmdetail.length() - 1);
//                    } else { // TODO id=18846822，cpmdetail为空，查询addeddetail
//                        System.out.println("null data:areadirect=" + areadirect + " flightcpm=" + flight
//                                + " cpmdetail=" + cpmdetail);
//                    }
//
//                    final String[] split = areadirect.split(",");
//                    for (final String key : split) {
//                        final Long flightPre = flightMap.get(key);
//                        final double ratio = getRatio(key, cpmdetailSub);
//                        final double flightCur = flightPre == null ? flight * ratio : flightPre + flight * ratio;
//                        flightMap.put(key, Math.round(flightCur));
//                    }
//                } else {
//                    final Long flightPre = flightMap.get(areadirect);
//                    final long flightCur = flightPre == null ? flight : flightPre + flight;
//                    flightMap.put(areadirect, flightCur);
//                }
//            }
//        } catch (final Exception e) {
//            e.printStackTrace();
//        } finally {
//            DBUtil.closers(rs);
//            DBUtil.closeps(st);
//            DBUtil.close(con);
//        }
//
//        for (final BeanStatAdvCpmFlightDay bean : resultList) {
//            final String ccode = getCcode(bean.getCcode());
//            final Long flight = flightMap.get(ccode);
//            bean.setFlight(flight == null ? 0 : flight);
//            bean.setcName(ProvinceCityManager.getInstance().getProvinceOrCityName(bean.getCcode()));
//        }
//    }
//
//
//    public static void main(final String[] args) {
//
//        if (args != null && args.length != 0) {
//            date = DateUtil.parseDate(args[0]);
//        }
//
//        try {
//            loadData();
//            new DayAdvCpmFlightReport().sendMail();
//            System.out.println("send mail success");
//        } catch (final Exception e) {
//            sendErrorMail();
//            System.out.println("send mail fail");
//            e.printStackTrace();
//        }
//
//        // parseDetial("{\"1072_320500\":0.04,\"1071_320200\":0.04,\"1047_320200\":0.81}");
//    }
//
//    private static Map<String, Double> parseDetial(final String detail) {
//        final Map<String, Double> map = new HashMap<String, Double>();
//        try {
//            final JSONObject json = new JSONObject(detail);
//            final Iterator<String> keys = json.keys();
//            while (keys.hasNext()) {
//                final String key = keys.next();
//                final double value = (Double) json.get(key);
//                final String ccode = key.substring(key.indexOf("_") + 1, key.length());
//
//                final Double doublePro = map.get(ccode);
//                if (doublePro == null) {
//                    map.put(ccode, value);
//                } else {
//                    map.put(ccode, doublePro + value);
//                }
//            }
//            return map;
//        } catch (final JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static void sendErrorMail() {
//
//        // Vector<String> receivers = new Vector<String>();
//        // for (String string : ERR_ADDRESS) {
//        // receivers.add(string);
//        // }
//        //
//        // BaseSendMail.getInstance().sendMail(getTitile(), "qd error", "",
//        // receivers,
//        // "1024px");
//    }
//
//    public void drawData(final StringBuffer html) {
//
//        if (resultList != null && resultList.size() > 0) {
//            html.append(HTMLUtil.startTR(""));
//            // html.append(HTMLUtil.makeTD("rowspan=" + aks.length
//            // + " style=\"font: bold 12px;color:#000;\"", dateStr));
//
//            final int i = 0;
//            for (final BeanStatAdvCpmFlightDay bean : resultList) {
//
//                final String ccode = bean.getCcode();
//                final String cName = bean.getcName();
//                if (i != 0) {
//                    html.append(HTMLUtil.startTR(""));
//                }
//                html.append(HTMLUtil.makeTD("style=\"font: bold 12px;color:#000;text-align: center;\"", cName));
//                html.append(HTMLUtil.makeTD("style=\"font: bold 12px;color:#000;text-align: left;\"", ccode));
//
//                final Long cpm = bean.getCpm();
//                if (cpm != null) {
//                    html.append(HTMLUtil.makeTD("style=\"font: 12px;color:#000;text-align: right;\"", Util
//                            .formatnumber(cpm)));
//                } else {
//                    html.append(HTMLUtil.makeTD(null, ""));
//                }
//
//                final Long flight = bean.getFlight();
//                if (flight != null) {
//                    html.append(HTMLUtil.makeTD("style=\"font: 12px;color:#000;text-align: right;\"", Util
//                            .formatnumber(flight)));
//                } else {
//                    html.append(HTMLUtil.makeTD(null, ""));
//                }
//
//                html.append(HTMLUtil.closeTR());
//            }
//            html.append(HTMLUtil.closeTR());
//        } else {
//            throw new IllegalArgumentException("no data");
//        }
//    }
//
//
//    // 画信体
//    public String DrawMailBody() {
//        final StringBuffer html = new StringBuffer();
//        html
//        .append(HTMLUtil
//                .startTable(" width=900 cellpadding=0 border=1  bordercolor=\"black\"  "
//                        + " style=\"text-align:center;border-collapse:collapse;word-break:break-all;word-wrap:break-word;\" "));
//        html.append(drawTitle());
//        drawData(html);
//        html.append(HTMLUtil.closeTable());
//        return html.toString();
//    }
//
//    public String drawTitle() {
//        final StringBuffer html = new StringBuffer();
//
//        html.append(HTMLUtil.startTR("class=\"data3\""));
//        html.append(HTMLUtil.makeTD("style=\"font: bold 12px;color:#000;\"", "城市"));
//        html.append(HTMLUtil.makeTD("style=\"font: bold 12px;color:#000;\"", "城市code"));
//        html.append(HTMLUtil.makeTD("style=\"font: bold 12px;color:#000;\"", "CPM"));
//        html.append(HTMLUtil.makeTD("style=\"font: bold 12px;color:#000;\"", "FLIGHT"));
//
//        html.append(HTMLUtil.closeTR());
//        return html.toString();
//    }
//
//    /**
//     * 根据时间获得需要发送地址
//     * @return
//     */
//    private String[] getAddress() {
//        // if (DateUtil.getHourOfDay(System.currentTimeMillis()) < 10) {
//        return ADDRESS1;
//        // } else {
//        // return ADDRESS2;
//        // }
//    }
//
//    public void sendMail() {
//
//        final String content = DrawMailBody();
//
//        System.err.println(content);
//
//        final Vector<String> receivers = new Vector<String>();
//        receivers.clear();
//
//        final String[] address = getAddress();
//        for (final String string : address) {
//            receivers.add(string);
//        }
//        BaseSendMail.getInstance().sendMail(getTitile(), content, "", receivers,
//        "1024px");
//    }
//
//}
