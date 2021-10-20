package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author chenliang
 * @date 2021-08-25 6:29 下午
 */
public class Test7 {

    public static void main(String[] args) {

        Person person = new Person("chenliang");
        System.out.println(person.toString());

        updateName(person);

        System.out.println(person.toString());

    }

    private static void updateName(Person person) {

        System.out.println(person.toString());
        person.setName("xipeng");
    }

    @Data
    @AllArgsConstructor
    public static class Person{
        private String name;
    }
}
