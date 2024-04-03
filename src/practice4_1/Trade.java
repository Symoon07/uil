package practice4_1;

import java.util.*;
import java.io.*;

public class Trade {
    HashMap<String, ArrayList<String>> g;
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Trade.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int x = f.nextInt(), y = f.nextInt();
            HashMap<String, Integer> hm = new HashMap<>();
            g = new HashMap<>();
            while (y --> 0) {
                String a = f.next();
                hm.put(a, f.nextInt());
                g.putIfAbsent(a, new ArrayList<>());
            }
            while (x --> 0) {
                f.next();
                int n = f.nextInt();
                while (n --> 0) {
                    String a = f.next();
                    g.putIfAbsent(a, new ArrayList<>());
                    g.get(a).add(f.next());
                }
            }
            int out = 0;
            for (String key : hm.keySet()) {
                if (find(key)) {
                    out += hm.get(key);
                }
            }
            System.out.println(out);
        }

        f.close();
    }

    public boolean find(String start) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> v = new HashSet<>();
        q.add(start);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (v.contains(cur)) {
                continue;
            }
            if (cur.equals("gold")) {
                return true;
            }
            v.add(cur);
            q.addAll(g.get(cur));
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        new Trade().run();
    }
}