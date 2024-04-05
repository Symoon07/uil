package p4_4_2024;

import java.util.*;
import java.io.*;

public class Fixing {
    char[][] mat;
    int[][][] smat;
    int min;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/p4_4_2024/Fixing.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            mat = new char[n][n];
            smat = new int[1 << 4][n][n];
            int sr = 0, sc = 0;
            for (int i = 0; i < n; i++) {
                String s = f.next();
                mat[i] = s.toCharArray();
                for (int j = 0; j < 1 << 4; j++) {
                    Arrays.fill(smat[j][i], Integer.MAX_VALUE);
                }
                if (s.contains("J")) {
                    sr = i;
                    sc = s.indexOf("J");
                }
            }
            min = Integer.MAX_VALUE;
            go(sr, sc, 0, 0);
            System.out.println(min + " seconds");
        }

        f.close();
    }

    public void go(int r, int c, int s, int mask) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat.length || mat[r][c] == '#' || s >= smat[mask][r][c]) {
            return;
        }
        int idx = "MWDA".indexOf(mat[r][c]);
        if (idx != -1) {
            mask |= 1 << idx;
            s += 10;
        }
        if (mask == 15) {
            min = Math.min(min, s);
        }
        smat[mask][r][c] = s++;
        for (int i = 0; i < 4; i++) {
            int nr = r + vr[i];
            int nc = c + vc[i];
            if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat.length && mat[nr][nc] != '#' && s < smat[mask][nr][nc]) {
                go(nr, nc, s, mask);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Fixing().run();
    }
}