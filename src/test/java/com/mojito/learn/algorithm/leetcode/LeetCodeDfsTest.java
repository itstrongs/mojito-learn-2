package com.mojito.learn.algorithm.leetcode;

import com.mojito.learn.algorithm.TreeAlgorithm;
import com.mojito.learn.algorithm.leetcode.helper.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liufengqiang
 * @date 2021-03-04 13:02:51
 */
class LeetCodeDfsTest {

    private TreeAlgorithm treeDemo;
    private LeetCodeDfs leetCodeDfs;

    @BeforeEach
    void init() {
        treeDemo = new TreeAlgorithm();
        leetCodeDfs = new LeetCodeDfs();
    }

    @Test
    void isBalanced() {
        System.out.println(leetCodeDfs.isBalanced(treeDemo.buildTree("[1,2,2,3,null,null,3,4,null,null,4]")));
    }

    @Test
    void getImportance() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
        employees.add(new Employee(2, 3, new ArrayList<>()));
        employees.add(new Employee(3, 3, new ArrayList<>()));
        System.out.println(leetCodeDfs.getImportance(employees, 1));
    }
}
