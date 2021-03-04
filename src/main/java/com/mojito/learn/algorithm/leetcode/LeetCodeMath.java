package com.mojito.learn.algorithm.leetcode;

/**
 * 力扣 - 数学
 *
 * @author liufengqiang
 * @date 2021-03-04 11:29:23
 */
public class LeetCodeMath {

    /**
     * 507. 完美数
     */
    public boolean checkPerfectNumber(int num) {
        // 枚举
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
//        return sum - num == num;

        // 欧几里得-欧拉定理：每个偶完全数都可以写成 2^{p-1}(2^p-1) 的形式，其中 p 为素数（梅森素数）。
        int[] primes = new int[]{2, 3, 5, 7, 13, 17, 19, 31};
        for (int prime : primes) {
            if (pn(prime) == num) {
                return true;
            }
        }
        return false;
    }

    private int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
}
