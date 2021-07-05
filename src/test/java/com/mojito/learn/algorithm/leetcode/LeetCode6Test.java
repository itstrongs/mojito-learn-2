package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.common.TreeAlgorithm;
import com.mojito.learn.algorithm.leetcode.pojo.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liufengqiang
 * @date 2021-07-05 10:35:09
 */
class LeetCode6Test {

    private TreeAlgorithm treeDemo;
    private LeetCode6 leetCode;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCode = new LeetCode6();
    }

    @Test
    void tree2str() {
        String val = "[1,2,3,4]";
        System.out.println("根据二叉树创建字符串：" + leetCode.tree2str(treeDemo.buildTree(val, ",")));
    }

    @Test
    void getImportance() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(leetCode.getImportance(employees, 1));
    }
}
