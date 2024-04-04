package p11_16_2023;

import java.util.*;
import java.io.*;

public class Stelios {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Stelios.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int n = f.nextInt();
            String[] l = f.nextLine().split(" ");
            HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
            int[][] mat = new int[n][n];
            for (int i = 1; i < l.length; i++) {
                int a = l[i].charAt(0) - 'A';
                int b = l[i].charAt(1) - 'A';
                g.putIfAbsent(a, new ArrayList<>());
                g.putIfAbsent(b, new ArrayList<>());
                g.get(a).add(b);
                g.get(b).add(a);
            }
            for (int i = 0; i < n; i++) {
                Queue<Integer> q = new LinkedList<>();
                HashSet<Integer> v = new HashSet<>();
                q.add(i);
                q.add(0);
                while (!q.isEmpty()) {
                    int cur = q.poll(), d = q.poll();
                    if (v.contains(cur)) {
                        continue;
                    }
                    mat[i][cur] = d;
                    v.add(cur);
                    for (int next : g.get(cur)) {
                        q.add(next);
                        q.add(d + 1);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("-".repeat(n * 2 - 1));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Stelios().run();
    }

}