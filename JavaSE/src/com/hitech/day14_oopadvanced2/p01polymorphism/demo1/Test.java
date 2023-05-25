package com.hitech.day14_oopadvanced2.p01polymorphism.demo1;

public class Test {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("zhangsan");
        s.setAge(23);

        Teacher t = new Teacher();
        t.setName("lisi");
        t.setAge(24);

        Administrator admin = new Administrator();
        admin.setName("admin");
        admin.setAge(35);

        register(s);
        register(t);
        register(admin);
    }

    private static void register(Person p) {
        p.show();
    }
}
