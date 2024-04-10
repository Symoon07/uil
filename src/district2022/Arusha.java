package district2022;

import java.util.*;
import java.io.*;

public class Arusha {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Arusha.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            ArrayList<String> l = new ArrayList<>(List.of(f.next().split("")));
            char[] r = f.next().toCharArray();
            int n = 0;
            for (int i = 0; i < r.length; i++) {
                if (r[i] == 'R') {
                    n++;
                }
                else {
                    n--;
                }
            }
            Collections.rotate(l, n);
            System.out.println(l.toString().replaceAll("[\\[\\], ]", ""));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Arusha().run();
    }
}