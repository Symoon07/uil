package region2006;

import java.io.*;
import java.util.*;

public class Sort {

    public static void main(String[] args) throws Exception {
        new Sort().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2006/sort.in"));
        //Scanner file = new Scanner(System.in);

        int cases = f.nextInt();
        for (int i = 1; i <= cases; i++) {

            System.out.println("Data Set #" + i);
            int words = f.nextInt();
            HashMap<String, String> hm = new HashMap<>();
            ArrayList<String> in = new ArrayList<>();
            while (words-- > 0) {
                String word = f.next();
                in.add(new StringBuilder(word).reverse().toString().toLowerCase());
                hm.put(word.toLowerCase(), word);
            }
            Collections.sort(in);
            ArrayList<String> out = new ArrayList<>();
            for (String key : in) {
                String temp = new StringBuilder(key).reverse().toString();
                out.add(hm.get(temp));
            }
            for (String word : out) {
                System.out.println(word);
            }

        }

        f.close();
    }
}