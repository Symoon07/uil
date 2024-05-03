package region2024;

import java.util.*;
import java.io.*;

public class Wesley {
    char[][] m;
    boolean[][][] v;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/region2024/Wesley.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt();
            m = new char[row][col];
            v = new boolean[5][row][col];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i < row; i++) {
                String s = f.next();
                m[i] = s.toCharArray();
                if (s.contains("S")) {
                    sr = i;
                    sc = s.indexOf("S");
                }
                if (s.contains("E")) {
                    er = i;
                    ec = s.indexOf("E");
                }
            }
            go(sr, sc, 0);
            if (er == -1) {
                System.out.println("Guess I won't be home in time for dinner.");
            }
            else {
                boolean found = false;
                for (int i = 0; i < 5; i++) {
                    found |= v[i][er][ec];
                }
                System.out.println(found ? "The Great Escape." : "Guess I won't be home in time for dinner.");
            }
        }

        f.close();
    }

    public void go(int r, int c, int s) {
        if (r < 0 || r >= m.length || c < 0 || c >= m[r].length || v[s][r][c]) {
            return;
        }
        if (s == 0 && "#35".contains("" + m[r][c])) {
            return;
        }
        if (s == 2 && "#15".contains("" + m[r][c])) {
            return;
        }
        if (s == 3 && ".SE".contains("" + m[r][c])) {
            return;
        }
        if (s == 4 && "#13".contains("" + m[r][c])) {
            return;
        }
        v[s][r][c] = true;
        for (int i = 0; i < 4; i++) {
            go(r + vr[i], c + vc[i], (s + 1) % 5);
        }
    }

    public static void main(String[] args) throws Exception {
        new Wesley().run();
    }
}