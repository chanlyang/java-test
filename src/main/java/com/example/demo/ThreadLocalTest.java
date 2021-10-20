package com.example.demo;

/**
 * @author chenliang
 * @date 2021-09-23 2:39 下午
 */
public class ThreadLocalTest {


    //工具类
    public static class ContextUntil {

        private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

        public static void setId(String id) {
            threadLocal.set(id);
        }

        public static String getId() {
            try {
                return threadLocal.get();
            } finally {
                threadLocal.remove();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ContextUntil.setId("chenliang");

      /*  System.out.println(Thread.currentThread().getName() + ContextUntil.getId());

        new Thread(() -> {
            ContextUntil.setId("lilie");

            System.out.println(Thread.currentThread().getName() + ContextUntil.getId());
        }, "thread1").start();
        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName() + ContextUntil.getId());*/

        test1();

        test2();

        System.out.println(ContextUntil.getId());

        System.out.println(ContextUntil.getId());

    }

    public static void test1(){
        ContextUntil.setId("cccc");
    }

    public static void test2(){
        ContextUntil.setId("dddd");
    }

}
