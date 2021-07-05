package com.mojito.learn.algorithm.leetcode.pojo;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * @author liufengqiang
 * @date 2021-03-20 22:25:29
 */
@AllArgsConstructor
public class Employee {

    public int id;
    public int importance;
    public List<Integer> subordinates;
}
