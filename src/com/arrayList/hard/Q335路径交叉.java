package com.arrayList.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yxx
 * @date 2021/10/29 21:03
 * @Description: 给你一个整数数组 distance 。
 * <p>
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * <p>
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：distance = [2,1,1,2]
 * 输出：true
 */
public class Q335路径交叉 {
    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{2, 1, 1, 2}));
    }
    public static boolean isSelfCrossing(int[] distance) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int x = 0, y = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i % 4 == 0) {
                for (int j = 0; j < distance[i]; j++) {
                    boolean flag = set.add(x + "," + ++y);
                    if (!flag) return true;
                }
            } else if (i % 4 == 1) {
                for (int j = 0; j < distance[i]; j++) {
                    boolean flag = set.add(--x + "," + y);
                    if (!flag) return true;
                }
            } else if (i % 4 == 2) {
                for (int j = 0; j < distance[i]; j++) {
                    boolean flag = set.add(x + "," + --y);
                    if (!flag) return true;
                }
            } else {
                for (int j = 0; j < distance[i]; j++) {
                    boolean flag = set.add(++x + "," + y);
                    if (!flag) return true;
                }
            }
        }
        return false;
    }
}