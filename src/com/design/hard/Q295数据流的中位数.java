package com.design.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author yxx
 * @date 2021/8/27 11:24
 * @Description: 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class Q295数据流的中位数 {

    class MedianFinder {
        private ArrayList<Double> list;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            this.list = new ArrayList<Double>();
        }

        public void addNum(int num) {
            list.add(Double.valueOf(num));
            Collections.sort(list);
        }

        public double findMedian() {
            int n = list.size();
            return n % 2 == 0 ? (list.get(n / 2) + list.get(n / 2 - 1)) / 2 : list.get(n / 2);
        }
    }

}
