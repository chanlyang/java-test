package com.example.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author chenliang
 * @date 2021-04-29 8:02 下午
 */
public class Test2 {

    public static ArrayList<String> qushu(File file) throws IOException {
        //FileReader fr = null;
        //定义一个ArrayList存取最终得到的第三个数据；
        ArrayList<String> al = new ArrayList<String>();

        BufferedReader fbr = null;

        try {
            //创建读取流
            fbr = new BufferedReader(new FileReader(file));
            String buffer = null;
            //每次读取一行，读取到的字符串以“，”切割，得到字符串数组，并将其中的第三个数据存到ArrayList中
            while ((buffer = fbr.readLine()) != null) {

                al.add(fbr.readLine());


            }
        } catch (FileNotFoundException e) {

            System.out.println("未读到文件");
        } finally {
            fbr.close();
        }
        //返回ArrayList
        return al;


    }

    public static void main(String[] args) throws IOException {

        String path = Test1.class.getClassLoader().getResource("data.txt").getPath();
        // 读取文件
        File file = new File(path);
        ArrayList<String> al = null;
        al = qushu(file);

        List<List<String>> temp = Lists.partition(al, 500);

        List<String> policyNo = Lists.newArrayList();

        for(List<String> it : temp){
            StringBuffer sb = new StringBuffer();
            for(String v : it){
                sb.append(Joiner.on("").join("'", v, "'", ","));
            }
            policyNo.add(sb.toString());
        }


        for (String it : policyNo) {
            System.out.println(Joiner.on("").join("update  set  = '' where  in  (", it, ")"));
        }

    }
}




