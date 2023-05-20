package com.hitech.day09_code.test7;

public class StudentTest {
    public static void main(String[] args) {
        /*定义一个长度为3的数组，数组存储1~3名学生对象作为初始数据，学生对象的学号，姓名各不相同。
        学生的属性：学号，姓名，年龄。
        要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
        要求2：添加完毕之后，遍历所有学生信息。
        */

        //1.创建一个数组用来存储学生对象
        Student[] arr = new Student[3];

        //2.创建学生对象并添加到数组当中
        Student stu1 = new Student(1, "zhangsan", 20);
        Student stu2 = new Student(2, "lisi", 21);
        //Student stu3 = new Student(3, "wangwu", 22);

        arr[0] = stu1;
        arr[1] = stu2;
        //arr[2] = stu3;

        //要求1：再次添加一个学生对象，并在添加的时候进行学号的唯一性判断。
        Student stu4 = new Student(4, "zhaoliu", 23);
        //唯一性判断
        boolean flag = contains(arr, stu4.getId());
        if (flag) {
            System.out.println("当前id已存在，请修改id后再添加");
        } else {
            //添加学生对象：
            int count = getCount(arr);
            if (count == arr.length) {
                //1.数组已存满：只能创建一个新的数组，新数组的长度 = 老数组 + 1
                Student[] newArr = createNewArr(arr);
                newArr[count] = stu4;
                //要求2：添加完毕之后，遍历所有学生信息。
                printArr(newArr);
            } else {
                //2.数组未存满：直接添加
                //getCount获取到的是2，表示数组中已经有了2个元素
                //还有一层意思：如果下一次要添加数据，就是添加到2索引的位置
                arr[count] = stu4;
                printArr(arr);
            }
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

    public static Student[] createNewArr(Student[] arr) {
        Student[] newArr = new Student[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static int getCount(Student[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }

    public static boolean contains(Student[] arr, int id) {
        for (int i = 0; i < arr.length; i++) {
            Student stu = arr[i];
            if (stu != null) {
                int sid = stu.getId();
                if (sid == id) {
                    return true;
                }
            }
        }
        return false;
    }
}
