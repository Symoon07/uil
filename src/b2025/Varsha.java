package b2025;

import java.util.*;
import java.io.*;

public class Varsha {
    char[][][] m;
    boolean[][][] v;
    int[] vl = {-1, 1, 0, 0, 0, 0};
    int[] vr = {0, 0, -1, 1, 0, 0};
    int[] vc = {0, 0, 0, 0, -1, 1};

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Varsha.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int level = f.nextInt(), row = f.nextInt(), col = f.nextInt();
            m = new char[level][row][col];
            v = new boolean[level][row][col];
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    m[i][j] = f.next().toCharArray();
                }
            }
            int max = 0;
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    for (int k = 0; k < col; k++) {
                        if (m[i][j][k] == 'V' && !v[i][j][k]) {
                            max = Math.max(max, go(i, j, k));
                        }
                    }
                }
            }
            System.out.println(max);
        }

        f.close();
    }

    public int go(int l, int r, int c) {
        if (l < 0 || l >= m.length || r < 0 || r >= m[l].length || c < 0 || c >= m[l][r].length || m[l][r][c] != 'V' || v[l][r][c]) {
            return 0;
        }
        v[l][r][c] = true;
        int n = 1;
        for (int i = 0; i < 6; i++) {
            n += go(l + vl[i], r + vr[i], c + vc[i]);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        new Varsha().run();
    }

}