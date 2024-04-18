package b2022;

import java.util.*;
import java.io.*;

public class Rhea {
    char[][] mat;
    boolean[][] v;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    String rgb = "ROYGBIV";
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Rhea.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt();
            mat = new char[row][col];
            v = new boolean[row][col];
            int sr = 0, sc = 0, er = 0, ec = 0;
            for (int i = 0; i < row; i++) {
                String s = f.next();
                mat[i] = s.toCharArray();
                if (s.contains("*")) {
                    sr = i;
                    sc = s.indexOf("*");
                    mat[sr][sc] = 'R';
                }
                if (s.contains("#")) {
                    er = i;
                    ec = s.indexOf("#");
                    mat[er][ec] = 'V';
                }
            }
            go(sr, sc, 0);
            System.out.println(v[er][ec] ? "yes" : "no");
        }

        f.close();
    }

    public void go(int r, int c, int prev) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || v[r][c] || !(rgb.indexOf(mat[r][c]) - prev == 0 || rgb.indexOf(mat[r][c]) - prev == 1)) {
            return;
        }
        v[r][c] = true;
        for (int i = 0; i < 4; i++) {
            go(r + vr[i], c + vc[i], rgb.indexOf(mat[r][c]));
        }
    }

    public static void main(String[] args) throws Exception {
        new Rhea().run();
    }
}