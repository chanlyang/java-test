package com.example.demo;

/**
 * @author chenliang
 * @date 2021-06-02 5:54 下午
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                test(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1").start();

        new Thread(() -> {
            try {
                test(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();

        new Thread(() -> {
            try {
                test(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread3").start();

    }

    public static void test(Integer uid) throws InterruptedException {
        synchronized (uid) {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "结束执行");
        }
    }
}
