package com.atguigu.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();

                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;

            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLikedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLikedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLikedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);
        empLikedListArray[empLinkedListNo].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLikedListArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        int empLinkedListNo = hashFun(id);
        Emp empById = empLikedListArray[empLinkedListNo].findEmpById(empLinkedListNo);

        if (empById != null) {
            System.out.printf("在第 %d 条链表中找到雇员 %d", empLinkedListNo + 1, id);
        } else {
            System.out.println("在哈希表中没有找到该雇员～");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }

        curEmp.next = emp;
    }

    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }

        System.out.print("第" + (no + 1) + "的链表的信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }

            curEmp = curEmp.next;
        }
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }

            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }

        return curEmp;
    }
}