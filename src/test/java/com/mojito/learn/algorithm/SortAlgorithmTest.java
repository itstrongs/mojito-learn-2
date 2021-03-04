package com.mojito.learn.algorithm;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author liufengqiang
 * @date 2021-03-04 15:56:24
 */
class SortAlgorithmTest {

    private SortAlgorithm sortAlgorithm;
    private int[] arr = {187, 19, 21, 123, 134, 73, 918, 837, 1, 23};

    @BeforeEach
    void init() {
        sortAlgorithm = new SortAlgorithm();
        System.out.println("排序前：" + JSON.toJSONString(arr));
    }

    @AfterEach
    void after() {
        System.out.println("排序后：" + JSON.toJSONString(arr));
    }

    @Test
    void bubbleSort() {
        sortAlgorithm.bubbleSort(arr);
    }

    @Test
    void selectionSort() {
        sortAlgorithm.selectionSort(arr);
    }
}
