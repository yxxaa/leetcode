package com.arrayList.easy;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/7/9 9:25
 * @Description: 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * !!!!!!请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class Q面试题1710主要元素 {
    // 两次遍历先找出最多元素，再得到数量
    public int majorityElement(int[] nums) {
        int cad = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                cad = num;
            }
            if (cad == num) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == cad) {
                count++;
            }
        }
        return 2 * count > nums.length ? cad : -1;
    }

    // 排序+双指针
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = 1;
        while (right < n) {
            if (nums[left] != nums[right]) {
                if ((right - left) * 2 > n) {
                    return nums[left];
                }
                left++;
            }
            right++;
        }
        return (right - left) * 2 > n ? nums[left] : -1;

    }
}
