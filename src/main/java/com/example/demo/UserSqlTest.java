package com.example.demo;

import org.springframework.util.ClassUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author chenliang
 * @date 2021-08-11 6:58 下午
 */
public class UserSqlTest {

    public static final String DATE_FORMAT_YYMMDDHHMMssSSS = "yyMMddHHmmssSSS";


    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("user.txt").getPath();


        try (Stream<String> stream = Files.lines(Paths.get(path))) {

            //StringBuilder sql = new StringBuilder("select * from tb_nsip_insurance_user where phone in (");

            String sql = "update  set nickname = '%s',phone = '%s' where user_id = '%s';";
            stream.forEach(str -> {
                String[] userInfo = str.split("\t");

                //sql.append("'").append(userInfo[1]).append("',");
            });

            //System.out.println(sql.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getEntityIdByStr(String str) {
       /* if (StringUtils.isNotEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();

            return stringBuilder.toString();
        }*/
        return null;
    }

    public static String desensitize(String str) {
        // 字符串长度小于4，直接返回****
        /*if (StringUtils.isBlank(str) || str.length() < 4) {
            return "****";
        }*/
        // 明文长度70%
        int length = str.length() * 7 / 10;

        StringBuffer buffer = new StringBuffer(str);
        for (int i = length / 2; i < str.length() - length + length / 2; i++) {
            buffer.setCharAt(i, '*');
        }
        return buffer.toString();
    }
}
