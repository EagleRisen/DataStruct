package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode hero1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用", "智多星");
        HeroNode hero4 = new HeroNode(4,"林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode newHeroNode = new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        doubleLinkedList.list();
    }
}

//创建一个双向链表
class DoubleLinkedList {
    private  HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return  head;
    }

    //遍历双向链表
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public  void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void update(HeroNode newHeroNode) {
        if(head.next == null) {
            System.out.println("链表为空～～");
            return;
        }

        HeroNode temp = head.next;
        while (temp != null) {
            if(temp.no == newHeroNode.no) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
                break;
            }

            temp = temp.next;
        }
        if(temp == null) {
            System.out.println("没有找到节点");
        }
    }

    public void del(int no) {
        //双向链表只需要找到要删除的链表
        if(head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if(temp == null) {
                break;
            }

            if(temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag == true) {
            temp.pre.next = temp.next;
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的%d节点不存在\n", no);
        }
    }
}

//定义HeroNode,每个HeroNode就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode pre; //指向前一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //重写toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
