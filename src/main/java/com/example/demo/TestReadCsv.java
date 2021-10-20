package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.util.ClassUtils;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-07-28 8:23 下午
 */
public class TestReadCsv {


    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("testFude.txt").getPath();
        try (
                Stream<String> stream = Files.lines(Paths.get(path))) {

           // List<FudeRenewBo> renewBoList = Lists.newArrayList();
            stream.forEach(str -> {
                List<String> strList = Arrays.asList(str.split(",").clone());
                List<String> curr = Lists.transform(strList, it -> {
                    return it.replace("\"", "");
                });



            });

           // Map<String, List<FudeRenewBo>> stringListMap = renewBoList.stream().collect(Collectors.groupingBy(FudeRenewBo::getPolicyNo));
            List<String> policyNos = Lists.newArrayList();
            //stringListMap.entrySet().stream().forEach(e -> policyNos.add(e.getKey()));
            System.out.println(policyNos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
