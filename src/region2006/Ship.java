package region2006;

import java.io.*;
import java.util.*;

public class Ship {

    public static void main(String[] args) throws Exception {
        new Ship().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/regional2006/ship.in"));
        //Scanner file = new Scanner(System.in);

        int cases = file.nextInt();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hm.put((char) ('A' + i), i);
        }
        for (int i = 1; i <= cases; i++) {

            System.out.println("Data Set #" + i);
            char[][] mat = new char[10][10];
            for (int j = 0; j < 10; j++) {
                mat[j] = file.next().toCharArray();
            }

            int c = 5;
            int b = 4;
            int d = 3;
            int s = 3;
            int p = 2;
            int moves = file.nextInt();
            while (moves-- > 0) {
                String in = file.next();
                int row = hm.get(in.charAt(0));
                int col = Integer.parseInt(in.substring(1)) - 1;
                char cur = mat[row][col];
                switch (cur) {
                    case '.' -> System.out.println(in + " " + "miss");
                    case 'C' -> {
                        c--;
                        if (c == 0) {
                            System.out.println(in + " " + "sank my carrier!");
                        } else {
                            System.out.println(in + " " + "hit!");
                        }
                    }
                    case 'B' -> {
                        b--;
                        if (b == 0) {
                            System.out.println(in + " " + "sank my battleship!");
                        } else {
                            System.out.println(in + " " + "hit!");
                        }
                    }
                    case 'D' -> {
                        d--;
                        if (d == 0) {
                            System.out.println(in + " " + "sank my destroyer!");
                        } else {
                            System.out.println(in + " " + "hit!");
                        }
                    }
                    case 'S' -> {
                        s--;
                        if (s == 0) {
                            System.out.println(in + " " + "sank my submarine!");
                        } else {
                            System.out.println(in + " " + "hit!");
                        }
                    }
                    case 'P' -> {
                        p--;
                        if (p == 0) {
                            System.out.println(in + " " + "sank my patrol boat!");
                        } else {
                            System.out.println(in + " " + "hit!");
                        }
                    }
                }
            }

        }

        file.close();
    }
}