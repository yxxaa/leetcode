package com.arrayList.easy;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/10/20 15:14
 * @Description: 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 */
public class Q453最小操作次数使数组元素相等 {

    // n-1个数加1 = 1个数-1
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Arrays.stream(nums).min().getAsInt();
        for (int n : nums) {
            res += n - min;
        }
        return res;
    }
}
