package com.heap.hard;

import java.util.PriorityQueue;
import java.util.logging.Level;

/**
 * @author yxx
 * @date 2021/10/11 15:40
 * @Description:
 */
public class 剑指Offer41数据流中的中位数 {
    public class MedianFinder {
        private PriorityQueue<Integer> max;
        private PriorityQueue<Integer> min;


        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.min = new PriorityQueue<>((x, y) -> y - x);
            this.max = new PriorityQueue<>((x, y) -> x - y);
        }

        public void addNum(int num) {
            if (min.isEmpty() || num <= min.peek()) {
                min.offer(num);
                if (min.size() > max.size() + 1) {
                    max.offer(min.poll());
                }
            } else {
                max.offer(num);
                if (min.size() < max.size()) {
                    min.offer(max.poll());
                }
            }
        }

        public double findMedian() {
            if (min.size() > max.size()) {
                return (min.peek() + max.peek()) / 2.0;
            }
            return min.peek();
        }
    }

}
