package com.example.demo;

import com.google.common.collect.Lists;
import org.springframework.util.ClassUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-09-09 10:21 上午
 */
public class HuaxiaTest {

    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("huaxia1.txt").getPath();

        List<String> list = Lists.newArrayList();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            stream.forEach(it -> {
                list.add(it);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        List<List<String>> subList = Lists.partition(list, 200);
        String sql = "select * from  where order_id in (%s) and  in (1,2,3)";
        subList.forEach(it -> {
            StringBuilder sb = new StringBuilder();
            for (String str : it) {
                sb.append("'").append(str).append("',");
            }
            System.out.println(String.format(sql, sb.toString()));
        });
    }
}
