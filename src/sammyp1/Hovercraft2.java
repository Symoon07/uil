package sammyp1;

import java.util.*;
import java.io.*;

public class Hovercraft2 {
    char[][][] mat;
    int[][][][] smat;
    int[] vr = {-1, 1, 0, 0, 0, 0};
    int[] vc = {0, 0, -1, 1, 0, 0};
    int[] vh = {0, 0, 0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/sammyp1/Hovercraft2.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int height = f.nextInt(), row = f.nextInt(), col = f.nextInt(), obj = f.nextInt(), air = f.nextInt();
            mat = new char[height][row][col];
            smat = new int[1 << obj][height][row][col];
            int sh = 0, sr = 0, sc = 0, cnt = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < row; j++) {
                    mat[i][j] = f.next().toCharArray();
                    for (int k = 0; k < col; k++) {
                        if (mat[i][j][k] == 'S') {
                            sh = i;
                            sr = j;
                            sc = k;
                        }
                        if (mat[i][j][k] == 'o') {
                            mat[i][j][k] = (char) cnt++;
                        }
                    }
                    for (int k = 0; k < 1 << obj; k++) {
                        Arrays.fill(smat[k][i][j], Integer.MAX_VALUE);
                    }
                }
            }
            go(sh, sr, sc, 0, 0);
            System.out.println(smat[(1 << obj) - 1][sh][sr][sc] <= air ? "Mission Success." : "That's Tough Homey.");
        }

        f.close();
    }

    public void go(int h, int r, int c, int mask, int s) {
        if (h < 0 || h >= mat.length || r < 0 || r >= mat[h].length || c < 0 || c >= mat[h][r].length || mat[h][r][c] == '#' || s >= smat[mask][h][r][c]) {
            return;
        }
        if (mat[h][r][c] < 8) {
            mask |= 1 << mat[h][r][c];
        }
        smat[mask][h][r][c] = s;
        for (int i = 0; i < 6; i++) {
            go(h + vh[i], r + vr[i], c + vc[i], mask, s + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Hovercraft2().run();
    }
}