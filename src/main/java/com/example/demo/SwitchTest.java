package com.example.demo;

/**
 * @author chenliang
 * @date 2021-06-15 2:15 下午
 */
public class SwitchTest {

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            boolean flag = false;
            switch (i) {
                case 2:
                    flag = true;
                    break;
                case 5:
                    flag = true;
                    break;
                default:
                    continue;
            }
            System.out.println(flag);
        }
    }
}
