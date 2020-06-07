package com.atguigu;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println("Student.setFirstName");
    }

    public static void main(String[] args) {
        //模版二
        System.out.println();
        System.out.println("args = " + Arrays.deepToString(args));
        System.out.println("Student.main");
        
        int num1 = 10;
        System.out.println("num1 = " + num1);
        int num2 = 20;
        System.out.println(num2);
        
        //模版三
        String[] arr = new String[]{"Tom", "Jerry", "Hanmeimei", "Lilei"};
        for(int i = 0; i < arr.length; i++)
        {

            System.out.println(i);
        }
        //变形
        for (String s : arr) {
            System.out.println(s);
        }
        
        //变形
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            System.out.println(s);
        }
        
        ArrayList list = new ArrayList<>();
        list.add(123);
        list.add(123);
        list.add(123);
        for (Object o : list) {
            
        }
        for (int i = 0; i < list.size(); i++) {
            
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            
        }

        if (list == null) {

        }

        if (list != null) {
            
        }
    }
}
