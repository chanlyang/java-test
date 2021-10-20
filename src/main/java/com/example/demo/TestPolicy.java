package com.example.demo;


import org.springframework.util.ClassUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-08-13 4:17 下午
 */
public class TestPolicy {

    public static void main(String[] args) {

        String path = ClassUtils.getDefaultClassLoader().getResource("test1.txt").getPath();
        StringBuilder sb = new StringBuilder("(");

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(it ->{
                sb.append("'").append(it).append("',");
            });

        } catch (Exception e) {

        }

        System.out.println(sb.toString());
    }
}
