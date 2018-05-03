package com.thomas.products.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangyang32 on 16/7/8.
 */
public class Test {
    public static void main(String[] args) {
        // 要验证的字符串
        String str = "in = {RateLimitedFSDirectory@4915} \"default(mmapfs(/opt/isaiah/node/data/debug_isaiah/nodes/0/indices/twitter/0/index),niofs(/opt/isaiah/node/data/debug_isaiah/nodes/0/indices/twitter/0/index))\"";
        // 邮箱验证规则
        String regEx = "mmapfs\\((\\S*?)\\)";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
       if(matcher.find()) {
           String group = matcher.group(1);
           System.err.println(group);
       }
    }
}
