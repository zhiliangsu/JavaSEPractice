package com.hitech.day09_oop2.test7;

public class StudentTest3 {
    public static void main(String[] args) {
        /*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
        学生的属性：学号，姓名，年龄。

        要求5：查询数组id为“2”的学生，如果存在，则将他的年龄+1岁*/

        //1.创建一个数组用来存储学生对象
        Student[] arr = new Student[3];

        //2.创建学生对象并添加到数组当中
        Student stu1 = new Student(1, "zhangsan", 20);
        Student stu2 = new Student(2, "lisi", 21);
        Student stu3 = new Student(3, "wangwu", 22);

        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;

        //要求5：查询数组id为“2”的学生，如果存在，则将他的年龄+1岁
        int index = getIndex(arr, 2);
        if (index >= 0) {
            Student stu = arr[index];
            int newAge = stu.getAge() + 1;
            stu.setAge(newAge);
            printArr(arr);
        } else {
            System.out.println("当前id不存在，修改失败");
        }

    }

    public static void printArr(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            if (stu != null) {
                System.out.println(stu.getId() + ", " + stu.getName() + ", " + stu.getAge());
            }
        }
    }

    public static int getIndex(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            if (stu != null) {
                int sid = stu.getId();
                if (sid == id) {
                    return i;
                }
            }
        }
        return -1;
    }

}
