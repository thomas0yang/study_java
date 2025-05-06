package com.thomas.products.alg.string;


/**
 * 最大回文字符串
 * https://www.cnblogs.com/leavescy/p/5878336.html
 */
public class HuiWenTest {

    public static void main(String[] args) {
        String testString = "ababac";
        System.out.println(findLongestPalindrome(testString)); //ababa
        System.out.println(findLongestPalindrome2(testString));
        System.out.println(findLongestPalindrome3(testString));
    }

    public static String findLongestPalindrome(String s){
        int len = s.length(); // 字符串长度
        String maxlengthString = "";  // 最长回文字符串长度
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++) {
                String substring = s.substring(i, j);
                if (isHuiWen(substring) && substring.length() >= maxlengthString.length()){
                    maxlengthString = substring;
                }
            }
        }
        return maxlengthString;
    }
    /**
     * 暴力判断是否为回文
     * @param s
     * @return
     */
    private static boolean isHuiWen(String s){
        if(null == s || "".equals(s))
            return false;
        // 对每个子串都从两边开始向中间遍历
        for(int i = 0, j = s.length()-1; i <= j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    /**
     * 中心扩展就是把给定的字符串的每一个字母当做中心，向两边扩展，这样来找最长的子回文串。
     * 算法复杂度为O(N^2)。
     * 但是要考虑两种情况：
     * 1、像aba，这样长度为奇数。
     * 2、想abba，这样长度为偶数。
     * @param s
     * @return
     */
    public static String findLongestPalindrome2(String s){
        int len = s.length(); // 字符串长度

        int maxlength = 0;
        int start = 0;

        // 以k为中心向两边扩展
        for(int k = 0; k < len; k++){
            // 类似于abba这种情况
            for(int i = k, j = k+1; i >= 0 && j < len; i--, j++){
                if(s.charAt(i) == s.charAt(j)) {
                    int tempMaxLength = j - i + 1;
                    if (tempMaxLength>maxlength) {
                        start = i;
                        maxlength = tempMaxLength;
                    }
                }
            }

            // 类似于aba这种情况
            for(int i = k-1, j = k+1; i >= 0 && j < len; i--, j++){
                if(s.charAt(i) == s.charAt(j)) {
                    int tempMaxLength = j - i + 1;
                    if (tempMaxLength>maxlength) {
                        start = i;
                        maxlength = tempMaxLength;
                    }
                }
            }
        }
        return s.substring(start,start+maxlength);
    }


    /**
     * 错误的
     * @param s
     * @return
     */
    public static String findLongestPalindrome3(String s){
        String str = s;
        int len = str.length();
        char[] list = str.toCharArray();
        int[] dp = new int[len+1];
        dp[0] = 0;
        int max = -1;
        int index = -1;
        for(int i = 0; i < len; i++){
            int tmp = dp[i];
            if(i-2*tmp >= 0 && list[i-2*tmp] == list[i]){
                dp[i+1] = tmp + 1;
                if(dp[i] > max){
                    max = dp[i];
                    index = i;
                }
            }else{
                dp[i+1] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = index - 2*max; j <= index; j++) sb.append(list[j]);

        return  sb.toString();
    }






}
