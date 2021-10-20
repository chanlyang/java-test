package com.example.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ClassUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-08-03 4:17 下午
 */
public class TestReadPolicyNo4Sql {

    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("fude112.txt").getPath();
        try (
                Stream<String> stream = Files.lines(Paths.get(path))) {

            //List<String> allPolicyNo = Lists.newArrayList();
            stream.forEach(str -> {

                // allPolicyNo.add(str);
                String sql = "update  set surrender_time = '%s' where policy_no = '%s';";
                String sql2 = "update  set uneffective_time = '%s' where policy_no = '%s';";

                String json = str.substring(str.indexOf("：") + 1);
                JSONObject jsonObject = JSONObject.parseObject(json);
                String json1 = jsonObject.getString("record");
                JSONArray jsonArray = JSONArray.parseArray(json1);
                jsonArray.stream().forEach(it -> {
                    JSONObject object = JSONObject.parseObject(it.toString());
                    if(object.getString("policyStatus").equals("7") ){
                        //System.out.println(String.format(sql, object.get("cancelDate"), object.get("policyNum")));
                        System.out.println(String.format(sql,object.get("expiryDate"), object.get("policyNum")));
                    }
                });
            });

          /*  String sql = "select distinct(b.order_id) from  a inner join tb_nsip_insurance_policy_order b on a.order_id=b.order_id  where a.policy_no != b.policy_no and  b.policy_no in (%s);";

            List<List<String>> partitionPolicyNo = Lists.partition(allPolicyNo, 500);
            for (List<String> curr : partitionPolicyNo) {
                StringBuilder sb = new StringBuilder();
                curr.forEach(it -> {
                    sb.append("'" + it + "',");
                });
                System.out.println(String.format(sql, sb.toString()));

            }
*/
        } catch (Exception e) {

        }

    }
}
