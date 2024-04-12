package a2022;

import java.util.*;
import java.io.*;

public class Sheal {
    HashSet<String> hs;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Sheal.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0 ) {
            String s = f.next();
            int k = f.nextInt();
            hs = new HashSet<>();
            getAll("", s.toCharArray(), new boolean[s.length()]);
            ArrayList<String> l = new ArrayList<>(hs);
            Collections.sort(l);
            System.out.println(l.get(k));
        }

        f.close();
    }

    public void getAll(String cur, char[] s, boolean[] v) {
        hs.add(cur);
        for (int i = 0; i < s.length; i++) {
            if (!v[i]) {
                v[i] = true;
                getAll(cur + s[i], s, v);
                v[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Sheal().run();
    }

}