package com.mojito.learn.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author liufengqiang
 * @date 2021-04-23 21:39:00
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println("input1：" + input1);
        System.out.println("input2：" + input2);

        String[] temp = input1.split(" ");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        System.out.println("流水线个数：" + m);
        System.out.println("作业数：" + n);
        List<Integer> times = Arrays.stream(input2.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());
        System.out.println("时长：" + times);

        if (m >= n) {
            System.out.println(times.get(times.size() - 1));
            return;
        }

        // 流水线工作任务
        List<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < times.size(); i++) {
            if (i < m) {
                tasks.add(times.get(i));
            } else {
                tasks.set(0, tasks.get(0) + times.get(i));
                tasks = tasks.stream().sorted().collect(Collectors.toList());
            }
        }

        System.out.println(tasks.get(tasks.size() - 1));
    }
}
