package com.arrayList.medium;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/8/3 9:17
 * @Description:
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 */
public class Q581最短无序连续子数组 {
    /*
    * 复制一个数组，将其排序后，子序列前后的内容应该相同，即可找出子序列左右节点
    * */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length,left = 0,right = n-1;
        int[] clone = nums.clone();
        Arrays.sort(clone);
        while (left < n && nums[left] == clone[left]){
            left++;
        }
        while (right > left && nums[right] == clone[right]){
            right--;
        }
        return right -left +1;
    }
//    O(n)直接找左右边界
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, right = -1;
        int min = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (max > nums[i]){
                right = i;
            } else {
                max = nums[i];
            }
            if (min < nums[n-1-i]){
                left = n-1-i;
            }else {
                min = nums[n-1-i];
            }
        }
        if (right == -1){
            return 0;
        }
        return right-left + 1;
    }
}
