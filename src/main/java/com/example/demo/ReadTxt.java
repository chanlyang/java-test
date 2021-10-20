package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenliang
 * @date 2021-06-16 6:08 下午
 */
public class ReadTxt {


    public static void main(String[] args) throws IOException {

        //String path = ReadTxt.class.getClassLoader().getResource("fude2.xlsx").getPath();
        File file = new File("/Users/chenliang/chenliang/github/fude2.csv");
        List<String> lines;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            lines = new ArrayList<>();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                lines.add(str);
            }
        }
        //截取每行{后的
        List<String> result = new ArrayList<>();
        for (String it : lines) {
            int index = it.indexOf("{");
            if (index == -1) {
                continue;
            }
            String temp = it.substring(it.indexOf("{"), it.length() - 1);

            System.out.println(temp);
        }

    }
}
