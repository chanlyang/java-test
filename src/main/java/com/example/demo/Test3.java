package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-07-05 3:13 下午
 */
public class Test3 {

    static BigDecimal A60 = BigDecimal.valueOf(60);
    static BigDecimal A100 = BigDecimal.valueOf(100);
    static BigDecimal A150 = BigDecimal.valueOf(150);


    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("fude.txt").getPath();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            final AtomicInteger i = new AtomicInteger(0);
            stream.forEach(str -> {
               // str = str.substring(1, str.length() -1 );
                JSONObject jsonObject = JSONObject.parseObject(str);

                String premiumList = jsonObject.getString("premium");

                JSONObject premiumObject = JSONObject.parseObject(premiumList);

              /*  BigDecimal amount1 = premiumObject.values().stream().map(it -> new BigDecimal(it.toString())).sorted(Comparator.comparing(it -> it.toString()).reversed()).findFirst().get();
                BigDecimal amount2 = premiumObject.values().stream().map(it -> new BigDecimal(it.toString())).sorted(Comparator.reverseOrder()).findFirst().orElse(null);

                if (!(amount1.compareTo(amount2) == 0)) {
                    i.getAndIncrement();
                }*/

                BigDecimal p_2_3 = premiumObject.getBigDecimal("2_3");
                BigDecimal p_4_12 = premiumObject.getBigDecimal("4_12");
                if (p_2_3.compareTo(A60) < 0 && p_4_12.compareTo(A100) > 0) {
                    i.getAndIncrement();
                }
                if (p_2_3.compareTo(A60) > 0 && p_2_3.compareTo(A100) < 0 && p_4_12.compareTo(A150) > 0) {
                    i.getAndIncrement();
                }


            });

            System.out.println(i.get());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
