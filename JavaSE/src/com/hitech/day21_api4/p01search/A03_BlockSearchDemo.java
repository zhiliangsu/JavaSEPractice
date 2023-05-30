package com.hitech.day21_api4.p01search;

public class A03_BlockSearchDemo {
    public static void main(String[] args) {
        /*
            分块查找
            核心思想：
                块内无序，块间有序
            实现步骤：
                1.创建数组blockArr存放每一个块对象的信息
                2.先查找blockArr确定要查找的数据属于哪一块
                3.再单独遍历这一块数据即可
        */
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};

        // 创建3个块的对象
        Block b1 = new Block(21, 5, 0, 5);
        Block b2 = new Block(37, 23, 6, 11);
        Block b3 = new Block(73, 48, 12, 17);

        // 定义数组用来管理三个块的对象(索引表)
        Block[] blockArr = {b1, b2, b3};

        // 定义一个变量来记录要查找的元素
        int number = 37;

        // 调用方法,传递索引表,数组和要查找的元素
        int index = getIndex(blockArr, arr, number);

        // 打印结果
        System.out.println(index);

    }

    // 利用分块查找的原理，查询number的索引
    private static int getIndex(Block[] blockArr, int[] arr, int number) {
        // 1.确定number是在哪一块中
        int indexBlock = findIndexBlock(blockArr, number);
        if (indexBlock == -1) {
            // 表示number不在当前数组中
            return -1;
        }
        // 2.获取这一块的起始索引和结束索引
        int startIndex = blockArr[indexBlock].getStartIndex();
        int endIndex = blockArr[indexBlock].getEndIndex();
        // 3.遍历
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    // 定义一个方法，用来确定number在哪一块当中
    public static int findIndexBlock(Block[] blockArr, int number) {
        // 从0索引遍历blockArr,如果number小于max,那么就表示number是在这一块当中的
        for (int i = 0; i < blockArr.length; i++) {
            if (number <= blockArr[i].getMax()) {
                return i;
            }
        }
        return -1;
    }
}

class Block {
    private int max;
    private int min;
    private int startIndex;
    private int endIndex;

    public Block() {
    }

    public Block(int max, int min, int startIndex, int endIndex) {
        this.max = max;
        this.min = min;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
