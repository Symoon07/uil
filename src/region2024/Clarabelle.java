package region2024;

import java.util.*;
import java.io.*;

public class Clarabelle {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/region2024/Clarabelle.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String in = f.next();
            TreeSet<String> ts = new TreeSet<>();
            for (int i = 0; i < in.length() - 2; i++) {
                if (in.charAt(i) == in.charAt(i + 2)) {
                    ts.add(in.substring(i, i + 3));
                }
            }
            if (ts.isEmpty()) {
                System.out.println("NONE");
            }
            else {
                for (String s : ts) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Clarabelle().run();
    }
}