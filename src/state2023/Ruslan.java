package state2023;

import java.util.*;
import java.io.*;

public class Ruslan {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Ruslan.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            HashMap<String, HashSet<String>> hm = new HashMap<>();
            String line = f.nextLine();
            while (!line.equals("=====")) {
                String[] temp = line.split(" ");
                hm.putIfAbsent(temp[0], new HashSet<>());
                hm.putIfAbsent(temp[1], new HashSet<>());
                hm.get(temp[0]).add(temp[1]);
                hm.get(temp[1]).add(temp[0]);
                line = f.nextLine();
            }
            System.out.println(paths("You", "Ruslan", hm, new HashSet<>()));
        }

        f.close();
    }

    public int paths(String cur, String rus, HashMap<String, HashSet<String>> hm, HashSet<String> v) {
        if (cur.equals(rus)) {
            return 1;
        }
        if (v.contains(cur)) {
            return 0;
        }
        int n = 0;
        v.add(cur);
        for (String neighbor : hm.get(cur)) {
            n += paths(neighbor, rus, hm, v);
        }
        v.remove(cur);
        return n;
    }

    public static void main(String[] args) throws Exception {
        new Ruslan().run();
    }

}