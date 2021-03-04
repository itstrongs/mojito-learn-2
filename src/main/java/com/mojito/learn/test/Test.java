package com.mojito.learn.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author liufengqiang
 * @date 2020-11-19 14:28:21
 */
public class Test {

    public static void main(String[] args) {
        String str = "学钢琴\n" +
                "\n\n\n" +
                "haha\nsdhfldsfkl鲨大富豪了是";
        System.out.println(str);
        String[] split = str.split("\n");

        String title = null;
        String desc = null;
        for (int i = 0; i < split.length; i++) {
            if (StringUtils.isNotBlank(split[i]) && StringUtils.isBlank(title)) {
                title = split[i];
            }

            if (i != 0 && StringUtils.isNotBlank(split[i]) && StringUtils.isBlank(desc)) {
                desc = split[i];
            }
        }
        System.out.println(Arrays.asList(split));
        System.out.println(title);
        System.out.println(desc);
    }
}
