package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chenliang
 * @date 2021-06-16 6:09 下午
 */
public class ShellReadTest {

    public static void main(String[] args) throws IOException {
        //cat命令，相当于是读取文件中的所有行，并输出
        File file = new File("/Users/duqi/IdeaProjects/LearnJava/src/main/java/org/java/learn/java8/stream/t1.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<>();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            lines.add(str);
        }

        //grep a，相当于filter
        lines = lines.stream().filter(s -> s.contains("a")).collect(Collectors.toList());

        //sort 按照字典序从小到大排序
        lines = lines.stream().sorted().collect(Collectors.toList());

        //uniq -c，统计相同的元素的个数
        Map<String, Long> integerMap =
                lines.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //sort -rn，排序后逆序输出
        List<Long> res = integerMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        res.forEach(System.out::println);
    }

}
