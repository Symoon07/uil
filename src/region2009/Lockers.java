package region2009;

import java.util.*;
import java.io.*;


public class Lockers {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2009/lockers.dat"));

        int cases = f.nextInt();
        f.nextLine();
        while (cases-- > 0) {
            int tar = f.nextInt();
            int first = f.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            if (first == tar) {
                System.out.println(first + " FOUND ON FIRST TRY");
            }
            else {
                String[] line = f.nextLine().split(" ");
                for (int i = 1; i < line.length; i++) {
                    list.add(Integer.parseInt(line[i]));
                }
                int diff = Math.abs(first - tar);
                for (int cur : list) {
                    int curDiff = Math.abs(cur - tar);
                    if (cur == tar) {
                        System.out.println(cur + " FOUND");
                    }
                    else if (diff == curDiff) {
                        System.out.println(cur + " SAME");
                    }
                    else if (curDiff > diff) {
                        System.out.println(cur + " COLDER");
                    }
                    else {
                        System.out.println(cur + " WARMER");
                    }
                    diff = curDiff;
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) throws Exception{
        new Lockers().run();
    }
}