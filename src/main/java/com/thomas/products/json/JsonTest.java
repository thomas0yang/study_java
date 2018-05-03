package com.thomas.products.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
    public static void main(String[] args) {

        String content =
                "{\"16\":[{\"id\":10040,\"name\":\"渠道非快消\"},{\"id\":10013,\"name\":\"销售组长1\"}],\"246\":[{\"id\":10040,\"name\":\"渠道非快消\"},{\"id\":10013,\"name\":\"销售组长1\"},null]}";

        JSONObject jsonObj = JSONObject.fromObject(content);

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
