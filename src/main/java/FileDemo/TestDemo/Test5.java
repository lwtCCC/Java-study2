package FileDemo.TestDemo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Test5 {

    public static void main(String[] args) {

        /*
        *
        * 统计文件的后缀
        *
        * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");
        Map<String, Integer> map = comFile(file);
        System.out.println(map);


    }

    public static Map<String, Integer> comFile(File file) {
        Map<String, Integer> map = new HashMap<>();
        map.put("无后缀", 0);
        File[] files = file.listFiles();
        if (files == null) {
            return null;
        }
        for (File file1 : files) {
            if (file1.isDirectory()) {
                Map<String, Integer> map1 = comFile(file1);
                if (map1 != null) {
                    map1.forEach((s, i) -> {
                        if (map.containsKey(s)) {
                            map.put(s, map.get(s) + i);
                        } else {
                            map.put(s, i);
                        }
                    });
                }
            } else {
                String[] arr = file1.getName().split("\\.");
                if (arr.length >= 2) {
                    if (map.containsKey(arr[arr.length - 1])) {
                        map.put(arr[arr.length - 1], map.get(arr[arr.length - 1]) + 1);
                    } else {
                        map.put(arr[arr.length - 1], 1);
                    }
                } else {
                    map.put("无后缀", map.get("无后缀") + 1);
                }
            }
        }
        return map;
    }
}
