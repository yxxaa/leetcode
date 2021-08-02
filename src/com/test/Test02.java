package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yxx
 * @date 2021/7/19 14:47
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) {
        ArrayList<Map> maps = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("1","2");
        maps.add(map);
        map.put("1","3");
        map.put("2","3");
        System.out.println(maps);
    }
}
