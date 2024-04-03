package practice4_1;

import java.util.*;
import java.io.*;

public class Catalog {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Catalog.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        TreeSet<Num> ts = new TreeSet<>();
        while (t --> 0) {
            ts.add(new Num(f.next()));
        }
        for (Num n : ts) {
            System.out.println(n);
        }

        f.close();
    }

    public class Num implements Comparable<Num> {
        String num;
        int id;

        public Num(String n) {
            num = n;
            id = 0;
            for (int i = 0; i < n.length(); i++) {
                if (Character.isDigit(n.charAt(i))) {
                    id += n.charAt(i) - 48;
                }
            }
        }

        @Override
        public int compareTo(Num o) {
            if (id == o.id) {
                return num.compareTo(o.num);
            }
            return id - o.id;
        }

        public String toString() {
            return num + " " + id;
        }
    }

    public static void main(String[] args) throws Exception {
        new Catalog().run();
    }

}