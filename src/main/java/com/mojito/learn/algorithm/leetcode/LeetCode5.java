package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.Node;
import com.mojito.learn.algorithm.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:32:55
 */
public class LeetCode5 {

    private int result;

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

    /**
     * 563. 二叉树的坡度
     */
    public int findTilt(TreeNode root) {
        count(root);
        return result;
    }

    /**
     * 任意节点的子树和
     */
    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = count(node.left);
        int right = count(node.right);
        result += Math.abs(left - right);
        return node.val + left + right;
    }

    /**
     * 589. N叉树的前序遍历
     */
    public List<Integer> preorder(Node root) {
        List<Integer> vals = new ArrayList<>();
        if (root == null) {
            return vals;
        }
        getChild(root, vals);
        return vals;
    }

    private void getChild(Node node, List<Integer> vals) {
        vals.add(node.val);
        node.children.forEach(o -> getChild(o, vals));
    }
}
