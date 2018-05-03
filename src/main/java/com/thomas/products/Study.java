package com.thomas.products;

import com.google.common.collect.ImmutableMap;

/**
 * Created by yangyang32 on 16/6/8.
 */
public class Study {
    public static void main(String[] args) {
//        System.out.println(TimeUnit.SECONDS.toMillis(5));
//        testIntern();

        assert 1==2 : "ereadsfasdfads"; //vm options -ea 生效
        System.out.println("ok");
    }

    private static void testImmutableMap() {
        ImmutableMap<String, Integer> map = ImmutableMap.of(
                "1", 1,
                "2", 2,
                "3", 3
        );
        System.out.println(map);

        ImmutableMap.Builder<String, Integer> cmdsBuilder = ImmutableMap.builder();
        for (int i = 0; i < 3; i++) {
            cmdsBuilder.put(String.valueOf(i), i+1);
        }
        ImmutableMap<String, Integer> map2 = cmdsBuilder.build();
        System.out.println(map2);


    }


    private  static  void testIntern(){
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        str5.intern(); //表示把str5的值"ab"同步到常量池中,
        // 注意点:1\str5的指针还没有变化,还是执行string("ab") 2\str5.intern()返回的字符串对象指针已经指向了常量池中的"ab"

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str3);
        System.out.println(str5.intern() == str4);
        System.out.println(str5.intern() == str4.intern());
    }
}
