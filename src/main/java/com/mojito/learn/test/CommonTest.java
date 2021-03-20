package com.mojito.learn.test;

/**
 * @author liufengqiang
 * @date 2020-12-13 15:20:03
 */
public class CommonTest {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = sb1;
        sb1.append("bbb");
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

        String a = "111";
        String b = "222";
        String c = a + b;
    }
}
