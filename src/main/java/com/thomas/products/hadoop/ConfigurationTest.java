package com.thomas.products.hadoop;

import java.io.IOException;

public class ConfigurationTest {

    public static void main(String[] args) throws IOException {

        for (String arg :args) {
            System.out.println(arg);
        }

//        Configuration conf = new Configuration();
////        conf.addResource("conf-1.xml");
//        System.err.println(conf.get("color"));
//        conf.set("color", "1");
//        System.err.println(conf.get("color"));
//
//        System.err.println(conf.getInt("size", 0));
//        System.err.println(conf.get("size-weight", "asdf"));
//        System.err.println(conf.get("adsfsa")); // 没有这个属性，null
//
//
//        String[] otherArgs = new GenericOptionsParser(conf,args).getRemainingArgs();
//        for (String arg : otherArgs) {
//            System.out.println(arg);
//        }
    }

}
