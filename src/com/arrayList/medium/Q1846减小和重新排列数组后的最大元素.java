package com.arrayList.medium;

import java.util.*;

/**
 * @author yxx
 * @date 2021/7/15 9:09
 * @Description: 给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * <p>
 * arr 中 第一个 元素必须为 1 。
 * 任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 * 你可以执行以下 2 种操作任意次：
 * <p>
 * 减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
 * 重新排列 arr 中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,1,2,1]
 * 输出：2
 * 解释：
 * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
 * arr 中最大元素为 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [100,1,1000]
 * 输出：3
 */
public class Q1846减小和重新排列数组后的最大元素 {
    public static void main(String[] args) {
        int[] ints = new int[10002];
        Arrays.fill(ints, 209);
        ints[3] =11111111;
        ints[888] = 100000;
        System.out.println(maximumElementAfterDecrementingAndRearranging(ints));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            temp[Math.min(arr[i],n)]++;
        }
        int miss = 0;
        for (int i = 2; i < n+1; i++) {
            if (temp[i] == 0) {
                ++miss;
            } else {
                miss -= Math.min(temp[i] - 1, miss); // miss 不会小于 0，故至多减去 miss 个元素
            }
        }
        return n - miss;

    }

    // 排序
    public static int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[n - 1];
    }
}
