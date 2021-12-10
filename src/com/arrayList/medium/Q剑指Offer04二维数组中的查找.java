package com.arrayList.medium;

/**
 * @author yxx
 * @date 2021/9/27 10:04
 * @Description:
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *              15
 *           11       19
 *         7   12   16   22
 *     4    8
 */
public class Q剑指Offer04二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        int i = 0,j = m-1;
        while (i<n && j>=0) {
            int a = matrix[i][j];
            if (a == target){
                return true;
            } else if (a< target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
