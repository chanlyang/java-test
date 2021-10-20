package com.example.demo;

import com.example.demo.aaa.User1;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenliang
 * @date 2021-09-01 5:52 下午
 */
public class CopyTest {

    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.setAge("12");
        user1.setName("asds");

        com.example.demo.model.User1 user11 = new com.example.demo.model.User1();
        BeanUtils.copyProperties(user1, user11);

       // System.out.println(user11);

        Map<String, Object> param = new HashMap<>();
        param.put("stat",null);
    }
}
