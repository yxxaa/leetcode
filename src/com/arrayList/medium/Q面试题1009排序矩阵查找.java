package com.arrayList.medium;

/**
 * @author yxx
 * @date 2021/7/5 14:48
 * @Description: 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class Q面试题1009排序矩阵查找 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m<=0) return false;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        //从矩阵右上角开始搜索
        int col = matrix[0].length - 1;//列
        int row = 0;//行

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                //如果找到就直接返回
                return true;
            } else if (target < matrix[row][col]) {
                //如果查找的值大了，下一步往左找
                col--;
            } else if (target > matrix[row][col]) {
                //如果查找的值小了，下一步往下找
                row++;
            }
        }
        return false;
    }
}
