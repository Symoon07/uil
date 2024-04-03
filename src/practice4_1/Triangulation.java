package practice4_1;

import java.util.*;
import java.io.*;

public class Triangulation {
    int sx, sy;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Triangulation.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            sx = f.nextInt();
            sy = f.nextInt();
            int n = f.nextInt();
            TreeSet<V> ts = new TreeSet<>();
            while (n --> 0) {
                ts.add(new V(f.next(), f.nextInt(), f.nextInt()));
            }
            for (V v : ts) {
                System.out.print(v);
            }
            System.out.println();
        }

        f.close();
    }

    public class V implements Comparable<V> {
        String name;
        double dis;

        public V(String n, int x, int y) {
            name = n;
            dis = Math.sqrt(Math.pow(sx - x, 2) + Math.pow(sy - y, 2));
        }

        @Override
        public int compareTo(V o) {
            return Double.compare(dis, o.dis);
        }

        public String toString() {
            return name + " ";
        }
    }

    public static void main(String[] args) throws Exception {
        new Triangulation().run();
    }

}