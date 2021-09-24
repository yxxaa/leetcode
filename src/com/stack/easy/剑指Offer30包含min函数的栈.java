package com.stack.easy;

import java.util.Stack;

/**
 * @author yxx
 * @date 2021/9/23 10:00
 * @Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class 剑指Offer30包含min函数的栈 {
    class MinStack {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** initialize your data structure here. */
        public MinStack() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || stack2.peek()>=x){
                stack2.push(x);
            }
        }

        public void pop() {
            if (stack1.pop().equals(stack2.peek())){
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
