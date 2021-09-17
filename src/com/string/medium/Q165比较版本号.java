package com.string.medium;

/**
 * @author yxx
 * @date 2021/9/1 9:23
 * @Description:给你两个版本号 version1 和 version2 ，请你比较它们。
 *
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *
 * 返回规则如下：
 *
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 *  
 *
 * 示例 1：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 示例 2：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 示例 3：
 *
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 *
 */
public class Q165比较版本号 {
    public static void main(String[] args) {
        compareVersion("0.1","1.1");
    }

    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        for (int i = 0; i < Math.max(ver1.length, ver2.length); i++) {
            int v1 = 0, v2 = 0;
            if (i < ver1.length){
                v1 = Integer.valueOf( ver1[i]);
            }
            if (i < ver2.length){
                v2 = Integer.valueOf( ver2[i]);
            }
            if(v1 < v2){
                return -1;
            }
            if(v1 > v2){
                return 1;
            }
        }
        return 0;
    }
}
