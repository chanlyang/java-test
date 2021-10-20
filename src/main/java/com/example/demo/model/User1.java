package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenliang
 * @date 2021-09-01 5:48 下午
 */
@Data
public class User1 implements Serializable {

    private String name;
    private String age;
}
