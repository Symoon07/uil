package region2012;

import java.util.*;
import java.io.*;

public class MostLeast {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/MostLeast.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int most = 0;
            int least = Integer.MAX_VALUE;
            String[] line = f.nextLine().replaceAll("\\.", "").replaceAll(",", "").replaceAll("\\?", "").split(" ");
            HashMap<String, Integer> hm = new HashMap<>();
            for (int i = 0; i < line.length; i++) {
                hm.putIfAbsent(line[i], 0);
                hm.put(line[i], hm.get(line[i]) + 1);
                most = Math.max(most, hm.get(line[i]));
            }
            for (String key : hm.keySet()) {
                if (hm.get(key) < least) {
                    least = hm.get(key);
                }
            }
            ArrayList<String> m = new ArrayList<>();
            ArrayList<String> l = new ArrayList<>();
            for (String key : hm.keySet()) {
                if (hm.get(key) == most) {
                    m.add(key);
                }
                if (hm.get(key) == least) {
                    l.add(key);
                }
            }
            Collections.sort(m);
            Collections.sort(l);
            System.out.print(most + " ");
            for (String s : m) {
                System.out.print(s + " ");
            }
            System.out.println();
            System.out.print(least + " ");
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new MostLeast().run();
    }

}