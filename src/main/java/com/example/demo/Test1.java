package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.*;
import java.util.List;

/**
 * @author chenliang
 * @date 2021-03-29 6:21 下午
 */
public class Test1 {


    ///export_result.json
    public static void main(String[] args) {
        String path = Test1.class.getClassLoader().getResource("export_result(1).json").getPath();
        String data1 = readJsonFile(path);
        Bodya bodya = JSONObject.parseObject(data1, Bodya.class);
        List<Dataa> dataa1 = bodya.getData();
        List<String> result1 = Lists.newArrayList();
        result1.add(data1);
        for (int i = 1; i <= 35; i++) {
            String path2 = Test1.class.getClassLoader().getResource("export_result(" + i + ").json").getPath();
            String data12 = readJsonFile(path);
            Bodya bodya2 = JSONObject.parseObject(data1, Bodya.class);
            List<Dataa> dataa12 = bodya.getData();
            List<String> result12 = Lists.newArrayList();
            result1.add(data12);
        }
    }

    /**
     * 读取json文件，返回json串
     *
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Data
    public static class Dataa {
        private String order_id;
        private String phone;
    }

    @Data
    public static class Bodya {
        private List<Dataa> data;
    }
}
