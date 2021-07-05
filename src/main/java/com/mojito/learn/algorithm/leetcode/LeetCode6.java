package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.datastructure.TreeNode;
import com.mojito.learn.algorithm.leetcode.pojo.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:33:37
 */
public class LeetCode6 {

    /**
     * 606. 根据二叉树创建字符串
     */
    public String tree2str(TreeNode t) {
        String str = tree2str2(t, false);
        return str.substring(1, str.length() - 1);
    }

    private String tree2str2(TreeNode t, boolean isRight) {
        if (t == null) {
            return isRight ? "" : "()";
        }
        if (t.left == null && t.right == null) {
            return "(" + t.val + ")";
        } else {
            return "(" + t.val + tree2str2(t.left, false) + tree2str2(t.right, true) + ")";
        }
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
