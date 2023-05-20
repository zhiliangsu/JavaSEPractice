package com.hitech.day09_code.test7;

public class StudentTest2 {
    public static void main(String[] args) {
        /*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
        学生的属性：学号，姓名，年龄。

        要求3：通过id删除学生信息
            如果存在，则删除，如果不存在，则提示删除失败。
        要求4：删除完毕之后，遍历所有学生信息。

       */

        //1.创建一个数组用来存储学生对象
        Student[] arr = new Student[3];

        //2.创建学生对象并添加到数组当中
        Student stu1 = new Student(1, "zhangsan", 20);
        Student stu2 = new Student(2, "lisi", 21);
        Student stu3 = new Student(3, "wangwu", 22);

        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;

        //要求3：通过id删除学生信息
        //如果存在，则删除，如果不存在，则提示删除失败。
        int index = getIndex(arr, 4);
        if (index >=0) {
            arr[index] = null;
            //要求4：删除完毕之后，遍历所有学生信息。
            printArr(arr);
        }else {
            System.out.println("当前id不存在，删除失败");
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
