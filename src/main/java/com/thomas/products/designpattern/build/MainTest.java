package com.thomas.products.designpattern.build;

/**
 * Created by yangyang32 on 16/10/6.
 */
public class MainTest {
    public static void main(String[] args) {
        Settings settings = Settings.settingsBuilder()
                .put("1", "地基")
                .put("2", "结构")
                .put("3", "细节")
                .put("4", "装修")
                .build();
        System.out.println(settings);
    }
}
