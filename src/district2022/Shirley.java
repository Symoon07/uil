package district2022;

import java.util.*;
import java.io.*;

public class Shirley {
    TreeMap<Integer, String> tm;
    int[][] mat;
    boolean[][] v;
    int trees, area;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2022/Shirley.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0;
        while (tcase++ < t) {
            int row = f.nextInt(), col = f.nextInt();
            mat = new int[row][col];
            v = new boolean[row][col];
            tm = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] >= 250 && !v[i][j]) {
                        trees = 0;
                        area = 0;
                        go(i, j);
                        if (area >= 2) {
                            tm.put(trees, String.format("%.1f", 100. * area / row / col));
                        }
                    }
                }
            }
            System.out.println("Case #" + tcase + ":");
            int i = 0;
            for (int k : tm.keySet()) {
                if (i++ == 3) {
                    break;
                }
                System.out.println(k + " " + tm.get(k));
            }
            System.out.print("NONE\n".repeat(Math.max(3 - i, 0)));
            System.out.println("^".repeat(12));
        }

        f.close();
    }

    public void go(int r, int c) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || v[r][c] || mat[r][c] < 250) {
            return;
        }
        v[r][c] = true;
        trees += mat[r][c];
        area++;
        for (int i = 0; i < 4; i++) {
            go(r + vr[i], c + vc[i]);
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Shirley().run();
    }
}