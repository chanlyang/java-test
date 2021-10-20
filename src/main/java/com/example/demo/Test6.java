package com.example.demo;

import org.springframework.util.ClassUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-07-23 2:16 下午
 */
public class Test6 {

    public static void main(String[] args) throws IOException {
        String path = ClassUtils.getDefaultClassLoader().getResource("data.txt").getPath();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            StringBuilder sb = new StringBuilder("select * from  where order_id in (");

            stream.forEach(str -> {
                sb.append("'").append(str).append("',");
            });
            sb.append(");");

            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
