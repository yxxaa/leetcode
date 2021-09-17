package com.arrayList.medium;

/**
 * @author yxx
 * @date 2021/9/17 10:59
 * @Description: 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 */
public class Q36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] col = new boolean[10][10], row = new boolean[10][10], area = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == '.') continue;
                int n = c - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row[i][n] || col[j][n] || area[idx][n]) return false;
                row[i][n] = col[j][n] = area[idx][n] = true;
            }
        }
        return true;
    }
}
