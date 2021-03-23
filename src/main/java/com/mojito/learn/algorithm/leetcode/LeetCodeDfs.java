package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;
import com.mojito.learn.algorithm.leetcode.helper.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 力扣 - 深度优先搜索
 *
 * @author liufengqiang
 * @date 2021-03-04 12:52:51
 */
public class LeetCodeDfs {

    /**
     * 面试题 04.04. 检查平衡性
     * 解法：自底向上
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(high(root.left) - high(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 面试题 04.04. 检查平衡性
     * 解法：自顶向下（性能更好），类似后序遍历
     */
    public boolean isBalanced2(TreeNode root) {
        return high2(root) >= 0;
    }

    private int high2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = high2(root.left);
        int right = high2(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    /**
     * 任意节点的高度
     */
    private int high(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(high(node.left), high(node.right)) + 1;
    }

    /**
     * 690. 员工的重要性
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(o -> o.id, o -> o));
        Employee employee = map.get(id);
        dfs(employee, map);
        return importance;
    }

    private int importance;

    void dfs(Employee employee, Map<Integer, Employee> map) {
        importance += employee.importance;
        if (employee.subordinates != null && employee.subordinates.size() != 0) {
            employee.subordinates.forEach(o -> dfs(map.get(o), map));
        }
    }
}
