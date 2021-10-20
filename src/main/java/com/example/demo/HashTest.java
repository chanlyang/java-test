package com.example.demo;

import com.google.common.collect.ImmutableList;
import org.apache.commons.compress.utils.Lists;

import java.util.Collections;
import java.util.List;

/**
 * @author chenliang
 * @date 2021-06-17 4:08 下午
 */
public class HashTest {

    public static void main(String[] args) {
       List<String> list = Lists.newArrayList();
        // [0,30) 12/7,[30,60) 3/10, [60,100) 9/7
        // 32  [0, 2, 5, 8, 14, 14, 20, 21, 22, 25, 29, 29, 35, 44, 52, 62, 63, 63, 66, 70, 75, 75, 84, 99]
        //64  [0, 2, 7, 12, 21, 27, 27, 31, 35, 36, 37, 37, 39, 41, 42, 55, 57, 69, 72, 75, 76, 76, 90, 98]

        List<Long> integers = Lists.newArrayList();
        for(String it : list){
            integers.add(Math.abs(MurmurHash.hash64(it)  % 100));
        }
        Collections.sort(integers);
        System.out.println(integers);
    }
}
