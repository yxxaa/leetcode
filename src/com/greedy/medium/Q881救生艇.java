package com.greedy.medium;

import java.util.Arrays;

/**
 * @author yxx
 * @date 2021/6/24 14:51
 * @Description: 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 */
public class Q881救生艇 {
    // 贪心 + 双指针
    // 关键点最多只能两人一艘船
    // 排序后将最轻的和最重的相加能否一艘船，不能的话重的人单独一艘，
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int res = 0, left = 0, right = n - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            res++;
        }
        return left == right ? res + 1 : res;
    }
}
