package com.thomas.products.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangyang32 on 16/7/8.
 */
public class Test {
    public static void main(String[] args) {
        // 要验证的字符串
        String str = "sum(case when #{wm_order_pay_type} = 2 then #{finish_ord_num} end)";
        // 邮箱验证规则
        String regEx = "#\\{([\\w]*?)\\}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        Matcher matcher = pattern.matcher(str);
//        // 字符串是否与正则表达式相匹配
//       if (matcher.find()) {
//           String group = matcher.group();
//           System.err.println(group);
//       }

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // 将匹配之前的字符串复制到sb,再将匹配结果替换为："favour"，并追加到sb
            String group = matcher.group(1);
            matcher.appendReplacement(sb, "t0."+group);
        }
        matcher.appendTail(sb);
        System.out.println(sb);
    }
}
