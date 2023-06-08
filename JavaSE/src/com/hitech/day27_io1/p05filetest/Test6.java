package com.hitech.day27_io1.p05filetest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test6 {
    public static void main(String[] args) throws IOException {
       /*
            需求：统计一个文件夹中每种文件的个数并打印。（考虑子文件夹）
            打印格式如下：
            txt:3个
            doc:4个
            jpg:6个


        */
        File src = new File("C:\\Users\\szl\\Desktop\\src");
        System.out.println(getCount(src));

    }

    /*
     * 作用：
     *       统计一个文件夹中每种文件的个数
     * 参数：
     *       要统计的那个文件夹
     * 返回值：
     *       用来统计map集合
     *       键：后缀名 值：次数
     *
     *       a.txt
     *       a.a.txt
     *       aaa（不需要统计的）
     *
     *
     * */
    public static HashMap<String, Integer> getCount(File src){
        HashMap<String, Integer> hm = new HashMap<>();
        File[] files = src.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    String[] arr = name.split("\\.");
                    if (arr.length >= 2) {
                        String suffix = arr[arr.length - 1];
                        updateMap(hm,suffix,1);
                        /* if (hm.containsKey(suffix)) {
                            int count = hm.get(suffix);
                            count+=1;
                            hm.put(suffix, count);
                        } else {
                            hm.put(suffix, 1);
                        } */
                    }
                }  else{
                    HashMap<String, Integer> sonMap = getCount(file);
                    Set<Map.Entry<String, Integer>> entries = sonMap.entrySet();
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        int value = entry.getValue();
                        updateMap(hm, key, value);
                        /* if (hm.containsKey(key)) {
                            int count = hm.get(key);
                            count+= value;
                            hm.put(key, count);

                        } else {
                            hm.put(key, value);
                        } */
                    }
                }
            }
        }
        return hm;
    }

    private static void updateMap(HashMap<String, Integer> hm, String key, int value) {
        if (hm.containsKey(key)) {
            int count = hm.get(key);
            count+= value;
            hm.put(key, count);

        } else {
            hm.put(key, value);
        }
    }


}
