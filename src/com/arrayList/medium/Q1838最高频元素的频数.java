package com.arrayList.medium;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/7/19 13:32
 * @Description:
 * 元素的 频数 是该元素在一个数组中出现的次数。
 *
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 *
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * 示例 1：
 *
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。
 * 示例 2：
 *
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 *
 */
public class Q1838最高频元素的频数 {
    public int maxFrequency(int[] nums, int k) {
        // 先升序
        Arrays.sort(nums);
        int n = nums.length, res = 0, cnt = 0;
        // 双指针遍历数组
        for(int i = 0, j = 0; i < n; i++) {
            // 指针区间数都变成当前位的数，加上所需的增加次数
            if(i > 0) cnt += (i - j) * (nums[i] - nums[i - 1]);
            // 如果所需的次数超过最大允许次数，则左侧边界开始向右，区间变小，所需次数也会变少
            while(cnt > k && i > j) {
                cnt -= (nums[i] - nums[j]);
                j ++;
            }
            // 取最大值
            res = Math.max(i - j + 1, res);
        }

        return res;
    }
    public int maxFrequency2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
