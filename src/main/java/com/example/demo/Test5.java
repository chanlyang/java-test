package com.example.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenliang
 * @date 2021-07-17 2:52 下午
 */
public class Test5 {


    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        TestCallable testCallable = new TestCallable();
        executorService.submit(testCallable);
    }



    public static class TestCallable implements Callable<String>{

        @Override
        public String call() throws Exception {

            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
            return "hello";
        }
    }
}
