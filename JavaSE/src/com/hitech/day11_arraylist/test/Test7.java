package com.hitech.day11_arraylist.test;

import java.util.ArrayList;

/*需求：
1，main方法中定义一个集合，存入三个用户对象。
      用户属性为：id，username，password
2，要求：定义一个方法，根据id查找对应的用户信息。
      如果存在，返回索引
      如果不存在，返回-1
*/
public class Test7 {
    public static void main(String[] args) {
        // 1.创建集合
        ArrayList<User> list = new ArrayList<>();

        // 2.添加对象并存入集合中
        User u1 = new User("heima001", "zhangsan", "123456");
        User u2 = new User("heima002", "lisi", "123456");
        User u3 = new User("heima003", "wangwu", "123456");
        list.add(u1);
        list.add(u2);
        list.add(u3);

        // 3.查找索引
        int index = getIndex(list, "heima003");
        System.out.println(index);

    }

    public static int getIndex(ArrayList<User> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            String uid = list.get(i).getId();
            if (uid.equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
