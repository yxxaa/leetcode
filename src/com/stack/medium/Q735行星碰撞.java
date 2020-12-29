package com.stack.medium;

import java.util.Stack;

/**
 * @Author: yxx
 * @Date: 2020/12/18 14:23
 * @Description: *
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 *
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 *
 * 示例 3:
 *
 * 输入:
 * asteroids = [10, 2, -5]
 * 输出: [10]
 * 解释:
 * 2 和 -5 发生碰撞后剩下 -5。10 和 -5 发生碰撞后剩下 10。
 * 示例 4:
 *
 * 输入:
 * asteroids = [-2, -1, 1, 2]
 * 输出: [-2, -1, 1, 2]
 * 解释:
 * -2 和 -1 向左移动，而 1 和 2 向右移动。
 * 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 */
public class Q735行星碰撞 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            collision:{
                while (!stack.isEmpty() && ast<0 && stack.peek()>0) {
                    if (-ast > stack.peek()){
                        stack.pop();
                        continue;
                    } else if (-ast == stack.peek()) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }

        }
        int[] res = new int[stack.size()];
        for (int i = stack.size()-1; i >=0 ; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
