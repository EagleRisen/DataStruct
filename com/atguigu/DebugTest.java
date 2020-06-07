package com.atguigu;

import java.util.HashMap;

public class DebugTest {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
        map.put("name", "Tome");
        map.put("age", "12");
        map.put("school", "Tsinghua");
        map.put("major", "computer");

        String age = map.get("age");
        System.out.println("age = " + age);

        map.remove("major");
        System.out.println(map);
    }
}
