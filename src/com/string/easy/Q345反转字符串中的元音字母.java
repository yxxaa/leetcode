package com.string.easy;

/**
 * @author yxx
 * @date 2021/8/19 9:06
 * @Description:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 */
public class Q345反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        String vowels = "aeiou";
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length-1;

        while (left < right){

            if (vowels.indexOf(chars[left]) == -1){
                left++;
            }
            if (vowels.indexOf(chars[right]) == -1){
                right--;
            }
            if (vowels.indexOf(chars[left]) != -1 && vowels.indexOf(chars[right]) != -1){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}
