package com.arrayList.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author yxx
 * @date 2021/9/18 13:33
 * @Description: 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 */
public class Q1207独一无二的出现次数 {
    public static void main(String[] args) {
        uniqueOccurrences(new int[]{1,2,2,1,1,3});
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        HashSet<Integer> set = new HashSet<>();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            boolean flag = set.add(entry.getValue());
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
