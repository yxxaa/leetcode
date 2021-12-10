package com.test;

/**
 * @author yxx
 * @date 2021/11/12 20:47
 * @Description:
 */
public class sum {
    public static void main(String[] args) {
        String a = "102 103 110 94 98 93 110";
        int b = 100;
        String[] s = a.split(" ");
        for (int i = 0; i < s.length; i++) {
            for (int j = i+1; j < s.length; j++) {
                
                int x = Math.abs(Integer.valueOf(s[i]) - 100);
                int y = Math.abs(Integer.valueOf(s[j]) - 100);

                if (x > y || (x == y && Integer.valueOf(s[j]) < Integer.valueOf(s[i]))) {
                    String temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
        return;
    }
}
