package region2009;

import java.util.*;
import java.io.*;


public class Target {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2009/target.dat"));

        int people = f.nextInt();
        int cases = f.nextInt();
        int n = 1;
        f.nextLine();
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        while (people-- > 0) {
            String[] line = f.nextLine().split(" ");
            String name = line[0];
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 1; i < line.length; i++) {
                String cur = line[i].substring(1,line[i].length()-1);
                int x = Integer.parseInt(cur.substring(0, cur.indexOf(",")));
                int y = Integer.parseInt(cur.substring(cur.indexOf(",")+1));
                temp.add(x);
                temp.add(y);
            }
            hm.put(name, temp);
        }
        ArrayList<Integer> tar = new ArrayList<>();
        while (cases-- > 0) {
            String cur = f.next();
            cur = cur.substring(1, cur.length()-1);
            int x = Integer.parseInt(cur.substring(0, cur.indexOf(",")));
            int y = Integer.parseInt(cur.substring(cur.indexOf(",")+1));
            tar.add(x);
            tar.add(y);
        }
        for (int i = 0; i < tar.size(); i+=2) {
            int min = Integer.MAX_VALUE;
            String name = "";
            for (String key : hm.keySet()) {
                ArrayList<Double> val = new ArrayList<>();
                ArrayList<Integer> temp = hm.get(key);
                for (int j = 0; j < temp.size();
                     j+=2) {
                    int x = temp.get(j);
                    int y = temp.get(j+1);
                    double dis = Math.sqrt(Math.pow(x - tar.get(i), 2) + Math.pow(y - tar.get(i+1), 2));
                    val.add(dis);
                }
                Collections.sort(val);
                int valc = (int) Math.round(val.get(0) + val.get(1) + val.get(2));
                if (valc < min) {
                    name = key;
                    min = valc;
                }
            }
            System.out.println("TARGET " + n++ + " " + name  + " " + min);
        }

    }
    public static void main(String[] args) throws Exception{
        new Target().run();
    }
}