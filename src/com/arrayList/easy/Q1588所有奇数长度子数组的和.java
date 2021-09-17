package com.arrayList.easy;

/**
 * @author yxx
 * @date 2021/8/29 11:22
 * @Description: 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q1588所有奇数长度子数组的和 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0, n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int len = 1; len + start <= n; len += 2) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    res += arr[i];
                }
            }
        }
        return res;
    }

    // 前缀和
    public int sumOddLengthSubarrays2(int[] arr) {
        int res = 0, n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }
        for (int start = 0; start < n; start++) {
            for (int len = 1; len + start <= n; len += 2) {
                int end = start + len - 1;
                res += pre[end + 1] - pre[start];
            }
        }
        return res;
    }
}
