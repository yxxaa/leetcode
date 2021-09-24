package com.math.easy;

/**
 * @author yxx
 * @date 2021/9/23 9:26
 * @Description:
 */
public class Q326q3的幂 {
    public boolean isPowerOfThree(int n) {
        if (n%3 == 0 && n/3 ==1){
            return true;
        }
        return isPowerOfThree(n/3) && isPowerOfThree(n%3);
    }
}
