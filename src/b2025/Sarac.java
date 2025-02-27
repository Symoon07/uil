package b2025;

import java.util.*;
import java.io.*;

public class Sarac {
    HashMap<String, HashSet<String>> hm;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Sarac.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t-- > 0) {
            int v = f.nextInt(), e = f.nextInt();
            hm = new HashMap<>();
            while (v --> 0) {
                hm.putIfAbsent(f.next(), new HashSet<>());
            }
            while (e-- > 0) {
                String[] in = f.next().split("->");
                hm.get(in[0]).add(in[1]);
            }
            System.out.println(cycle() ? "Deadlock exists; not good..." : "Deadlock free; all is well");
        }

        f.close();
    }

    public boolean cycle() {
        HashSet<String> v = new HashSet<>();
        HashSet<String> s = new HashSet<>();

        for (String k : hm.keySet()) {
            if (!v.contains(k) && go(k, v, s)) {
                return true;
            }
        }
        return false;
    }

    public boolean go (String cur, HashSet<String> v, HashSet<String> s) {
        if (s.contains(cur)) {
            return true;
        }
        if (v.contains(cur)) {
            return false;
        }
        v.add(cur);
        s.add(cur);
        for (String n : hm.get(cur)) {
            if (go(n, v, s)) {
                return true;
            }
        }
        s.remove(cur);
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Sarac().run();
    }

}