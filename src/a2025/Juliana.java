package a2025;

import java.util.*;
import java.io.*;

public class Juliana {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2025/Juliana.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(), m = f.nextInt(); f.nextLine();
        HashMap<String, Person> hm = new HashMap<>();
        while (m-- > 0) {
            String name = f.next() + " " + f.next();
            name = name.substring(0, name.length() - 1);
            int exp = f.nextInt();
            String major = f.next(), field = f.next();
            String[] con = f.nextLine().trim().split(" ");
            hm.put(name, new Person(name, major, field, exp, con));
        }
        while (n-- > 0) {
            String name = f.next() + " " + f.next();
            int exp = f.nextInt();
            String req = f.next();
            HashSet<String> v = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.add(name);
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (v.contains(cur)) {
                    continue;
                }
                v.add(cur);
                q.addAll(Arrays.asList(hm.get(cur).con));
            }
            String out = "";
            for (String p : v) {
                if (!p.equals(name) && hm.get(p).exp >= exp && (hm.get(p).major.equals(req) || hm.get(p).field.equals(req))) {
                    out += p + ", ";
                }
            }
            System.out.println(out.isEmpty() ? "" : out.substring(0, out.length() - 2));
        }

        f.close();
    }

    public class Person implements Comparable<Person> {
        String name, major, field;
        int exp;
        String[] con;

        public Person(String n, String m, String f, int e, String[] c) {
            name = n;
            major = m;
            field = f;
            exp = e;
            con = new String[c.length / 2];
            for (int i = 0; i < con.length; i++) {
                con[i] = c[i * 2] + " " + c[i * 2 + 1];
            }
        }

        @Override
        public int compareTo(Person o) {
            return name.compareTo(o.name);
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        new Juliana().run();
    }

}