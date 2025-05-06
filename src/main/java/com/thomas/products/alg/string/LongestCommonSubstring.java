package com.thomas.products.alg.string;


/**
 * 求两个字符串的最长公共子串
 * https://blog.csdn.net/tonglin12138/article/details/88679569
 * <p>
 * 这段代码定义了一个findLCS方法，它接受两个字符串参数并返回它们的最长公共子串的长度。
 * 在main方法中，我们调用findLCS方法并打印结果。
 * 这个方法使用了一个二维数组dp来存储子问题的解，并通过递归地检查字符是否相同来构建这个数组。
 * 最终的最长公共子串的长度是数组中的最大值。
 * <p>
 * 解题思路：
 * 1、把两个字符串分别以行和列组成一个二维矩阵。
 * 2、比较二维矩阵中每个点对应行列字符中否相等，相等的话值设置为1，否则设置为0。
 * 3、通过查找出值为1的最长对角线就能找到最长公共子串。
 * 从下图可以看到，str1和str2共有5个公共子串，但最长的公共子串长度为5。
 * <p>
 * a   b   c   b   c   e   d
 * a   1   0   0   0   0   0   0
 * c   0   0   1   0   1   0   0
 * b   0   1   0   1   0   0   0
 * c   0   0   1   0   1   0   0
 * b   0   1   0   1   0   0   0
 * c   0   0   1   0   1   0   0
 * e   0   0   0   0   0   1   0
 * f   0   0   0   0   0   0   0
 * <p>
 * 为了进一步优化算法的效率，我们可以再计算某个二维矩阵的值的时候顺便计算出来当前最长的公共子串的长度，
 * 即某个二维矩阵元素的值由record[i][j]=1演变为record[i][j]=1 +record[i-1][j-1]，
 * 这样就避免了后续查找对角线长度的操作了
 * a   b   c   b   c   e   d
 * a   1   0   0   0   0   0   0
 * c   0   0   1   0   1   0   0
 * b   0   1   0   2   0   0   0
 * c   0   0   2   0   3   0   0
 * b   0   1   0   3   0   0   0
 * c   0   0   2   0   4   0   0
 * e   0   0   0   0   0   5   0
 * f   0   0   0   0   0   0   0
 */

public class LongestCommonSubstring {

    public static String findLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        int maxLength = 0;
        int maxEnd = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    maxEnd = i;
                }
            }
        }
        return str1.substring(maxEnd - maxLength + 1, maxEnd + 1); //substring左闭右开, 从0开始
    }

    public static void main(String[] args) {
        int[][] dp = new int[1][5]; //1行 5列

//        String str1 = "OldSite:GeeksforGeeks.org";
//        String str2 = "NewSite:GeeksQuiz.com";
//        System.out.println("Length of the longest common substring is: " + findLCS(str1, str2));

        String preStr1 = "flower";
        String preStr2 = "flow";
        String preStr3 = "flight";
        System.out.println("Length of the longest common substring is: " + findLCS(findLCS(preStr1, preStr2), preStr3));
    }


}