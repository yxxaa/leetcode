package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yxx
 * @date 2021/7/19 14:47
 * @Description:
 */
public class Test02 {
    public static void main(String[] args) {
//        ArrayList<Map> maps = new ArrayList<>();
//        Map<String, String> map = new HashMap<>();
//        map.put("1","2");
//        maps.add(map);
//        map.put("1","3");
//        map.put("2","3");
//        System.out.println(maps);
        System.out.println(1 << 30 == Math.pow(2,30));
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put("33","44");
        map.get("33");
        ConcurrentHashMap.KeySetView<Object, Object> objects = map.keySet();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry<Object, Object> set:entries) {
            System.out.println(set.getKey());
        }
        System.out.println(1);
    }
}
