package region2009;

import java.util.*;
import java.io.*;


public class Base3 {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2009/base3.dat"));

        while (f.hasNext()) {
            String num = f.next();
            int out = 0;
            HashMap<String, Integer> hm = new HashMap<>();
            hm.put("M", 1);
            hm.put("A", -1);
            hm.put("O", 0);
            int val = 1;
            for (int i = num.length()-1; i >= 0; i--) {
                int cur = hm.get(num.substring(i,i+1));
                out += (cur * val);
                val *= 3;
            }
            System.out.println(out);
        }
    }
    public static void main(String[] args) throws Exception{
        new Base3().run();
    }
}