package com.mojito.learn.algorithm.common;

import java.util.Arrays;

/**
 * 十大排序算法
 *
 * @author liufengqiang
 * @date 2021-02-25 22:32:29
 */
public class SortAlgorithm {

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] data) {
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j + 1] < data[j]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public void selectionSort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                swap(arr, i, min);
            }
        }
    }

    /**
     * 插入排序
     */
    public int[] insertSort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];

            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] data, int l, int r) {
        if (l >= r - 1) {
            return;
        }
        int basic = data[l];
        // 计算断点m, n
        int i = l, m = l, n = r;
        int temp;
        while (i < n) {
            if (data[i] < basic) {
                temp = data[i++];
                data[i++] = data[m++];
                data[m++] = temp;
            } else if (data[i] > basic) {
                temp = data[i];
                data[i] = data[--n];
                data[--n] = temp;
            } else {
                ++i;
            }
        }
        quickSort(data, l, m);
        quickSort(data, n, r);
    }

    /**
     * 归并排序
     */
    private void mergeSort(int[] arr) {
        int[] arrTemp = Arrays.copyOf(arr, arr.length);
        mergeSort(arr, arrTemp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] arrTemp, int left, int right) {
        // 递归终止条件，子数组长度为1        
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, arrTemp, left, mid);
        mergeSort(arr, arrTemp, mid + 1, right);
        merge(arr, arrTemp, left, mid, right);
    }

    public static void merge(int[] arr, int[] arrTemp, int left, int mid, int right) {
        System.arraycopy(arr, left, arrTemp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        // 将需要合并的两个数组合起来全部遍历一遍，将其放入临时数组        
        for (int k = left; k <= right; k++) {
            // 先考虑两个边界问题，左边指针和右边指针都到头了，即一边处理结束的情况            
            //  左半边元素全部处理完毕，右半边元素都大于左半边，右边元素直接落下来到临时数组，右边指针动            
            if (i > mid) {
                arr[k] = arrTemp[j];
                j++;
                //  右半边指针到头了，左半边元素都大于右半边，左边元素直接落下来到临时数组，左边指针动            
            } else if (j > right) {
                arr[k] = arrTemp[i];
                i++;
                // 比较，遍历到的左边元素小于右边元素，左边元素进入临时数组，左边指针右动一位            
            } else if (arrTemp[i] < arrTemp[j]) {
                arr[k] = arrTemp[i];
                i++;
                // 比较，遍历到的左边元素大于右边元素，右边元素进入临时数组，右边指针向右动一位            
            } else {
                arr[k] = arrTemp[j];
                j++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
