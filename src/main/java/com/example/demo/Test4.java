package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-07-05 3:08 下午
 */
public class Test4 {

    public static void main(String[] args) throws IOException {
        String path = ClassUtils.getDefaultClassLoader().getResource("testSql.txt").getPath();

        InputStream inputStream = new FileInputStream(path);

        String result = new BufferedReader(new InputStreamReader(inputStream, "GBK"))
                .lines().collect(Collectors.joining(System.lineSeparator()));

        //String result = new String(ByteStreams.toByteArray(inputStream), "UTF-8");

        List<String> renewalStrList = Stream.of(result.split("\\|")).collect(Collectors.toList());

        List<String> policyNos = Lists.newArrayList();

        for (String renewalSyn : renewalStrList) {

        }

        //System.out.println(policyNos);

        List<List<String>> policyPartition = Lists.partition(policyNos,200);
        for (List<String> pt : policyPartition) {
            StringBuilder sb = new StringBuilder("select order_id,policy_no,order_status,create_time,update_time from tb_nsip_insurance_policy_order where order_status != 4 and policy_no in (");
            for (String it : pt) {
                sb.append("'" + it + "',");
            }
            sb.append(");");
            System.out.println(sb.toString());

        }

    }
}
