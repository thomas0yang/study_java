package com.thomas.products.alg.string;

/**
 * 括号匹配深度
 * 例如: "()()()"的深度是 1,"((()))"的深度是 3。
 * 牛牛现在给你一个合法的括号序列,需要你计算出其深度。
 */
public class KuohaoShenDu {
    public static void main(String[] args) {
        System.out.println(deep("()(adfas)()"));
        System.out.println(deep("((()(adsfa)))"));
    }


    private static int deep(String s){
        int length = s.length();
        int deep = 0;
        int maxDeep = 0;
        for (int i = 0; i < length-1; i++) {
            if (s.charAt(i) == '('){
                deep++;
            } else if (s.charAt(i) == ')'){
                deep--;
            }
            maxDeep = Math.max(maxDeep, deep);
        }
        return maxDeep;
    }

}
