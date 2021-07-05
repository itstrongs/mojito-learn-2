package com.mojito.learn.algorithm.interview;

/**
 * @author liufengqiang
 * @date 2021-05-11 20:06:01
 */
public class HuaweiTest0 {

    public int demo(String str) {
        // 任意位置到另一个位置是否是回文子串
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < str.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (str.charAt(i) != str.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
