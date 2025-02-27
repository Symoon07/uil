package b2025;

import java.util.*;
import java.io.*;

public class Howard {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Howard.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        LinkedHashMap<String, ArrayList<Player>> hm = new LinkedHashMap<>();
        hm.put("PG", new ArrayList<>());
        hm.put("SG", new ArrayList<>());
        hm.put("SF", new ArrayList<>());
        hm.put("PF", new ArrayList<>());
        hm.put("C", new ArrayList<>());
        while (t --> 0) {
            int number = f.nextInt();
            String name = f.next(), pos = f.next();
            double pts = f.nextDouble(), apg = f.nextDouble(), fga = f.nextDouble(), fta = f.nextDouble(), tpg = f.nextDouble();
            hm.get(pos).add(new Player(number, name, pts, apg, fga, fta, tpg));
        }
        for (String k : hm.keySet()) {
            Collections.sort(hm.get(k));
            System.out.println(k + ": " + hm.get(k).getFirst());
        }

        f.close();
    }

    public class Player implements Comparable<Player> {
        String name;
        int number;
        double ts, tr;

        public Player(int n, String nn, double pts, double apg, double fga, double fta, double tpg) {
            name = nn;
            number = n;
            ts = pts / (2 * (fga + .44 * fta));
            tr = apg / tpg;
        }

        @Override
        public int compareTo(Player o) {
            if (ts == o.ts) {
                return Double.compare(o.tr, tr);
            }
            return Double.compare(o.ts, ts);
        }

        public String toString() {
            return number + ". " + name;
        }
    }

    public static void main(String[] args) throws Exception {
        new Howard().run();
    }

}