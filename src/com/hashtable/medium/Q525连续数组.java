package com.hashtable.medium;

import java.util.HashMap;

/**
 * @author yxx
 * @date 2021/6/3 11:41
 * @Description:
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 */
public class Q525连续数组 {
    // 前缀和+哈希表
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maxLength = 0;
        int counter = 0;
        map.put(0,-1);
        for (int i = 0; i < n; i++) {
            if (nums[i]==1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)){
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(counter,i);
            }
        }
        return maxLength;
    }
}
