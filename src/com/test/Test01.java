package com.test;

/**
 * @author yxx
 * @date 2021/5/30 20:52
 * @Description:
 * 对于静态代码块和静态变量，按顺序执行
 */
public class Test01 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}
class A{
    static {
        System.out.println("静态代码块");
        m = 100;
    }
    static int m = 300;
    public A () {
        System.out.println("A类的无参构造方法");
    }
}
