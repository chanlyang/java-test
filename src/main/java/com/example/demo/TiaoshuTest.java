package com.example.demo;

import org.springframework.util.ClassUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-08-11 8:03 下午
 */
public class TiaoshuTest {
    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("tiaoshu.sql").getPath();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            stream.forEach(str -> {
                System.out.println(str.substring(0, str.indexOf(",")));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
