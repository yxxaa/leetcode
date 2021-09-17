package com.arrayList.medium;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/8/4 11:15
 * @Description: 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 */
public class Q611有效三角形的个数 {
    //    暴力
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = j + 1;
                while (k < n) {
                    if (nums[i] + nums[j] > nums[k]) {
                        res++;
                    }
                    k++;
                }

            }
        }
        return res;
    }
//二分
    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (right + left) / 2;
                    if (nums[i] + nums[j] > nums[mid]) {
                        left = mid + 1;
                        k = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                res += k-j;

            }
        }
        return res;
    }
}
