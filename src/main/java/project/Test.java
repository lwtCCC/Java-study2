package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws IOException {
        ArrayList<String> arr = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("./src/main/java/project/number.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int r;
        StringBuilder s = new StringBuilder();
        while ((r = fis.read()) != -1) {
            char c = (char) r;
            if(c == ' ') continue;
            if(c != ',') s.append(c);
            if(c == ',') {
                arr.add(s.toString());
                s.delete(0, s.length());
            }
        }
        fis.close();
        System.out.println(arr);
        int size = arr.size();
        System.out.println(Math.sqrt(110));
        System.out.println(Math.sqrt(111));
        //小数位是否大于0.5
        int temp = 111;
        int sqrt = (int)Math.sqrt(size);
        if(sqrt * sqrt == size) System.out.println(sqrt);
        else {
            System.out.println(sqrt);
            System.out.println(sqrt+1);
        }
        /*for(int i = (int) sqrt; i > 2 ; i--) {
            if (size % i == 0) {
                System.out.println(size);
                break;
            }
        }*/

    }
}
