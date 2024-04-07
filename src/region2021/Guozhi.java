package region2021;

import java.util.*;
import java.io.*;

public class Guozhi {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2021/Guozhi.dat"));
        //Scanner f = new Scanner(System.in);

        String dir = "NESW";
        int[] vr = {-1, 0, 1, 0};
        int[] vc = {0, 1, 0, -1};
        int T = f.nextInt(), Tcase = 0;
        while (Tcase++ < T) {
            int row = f.nextInt(), col = f.nextInt();
            int sr = 0, sc = 0, er = 0, ec = 0;
            char[][] mat = new char[row][col];
            boolean[][][] bmat = new boolean[4][row][col];
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
                for (int j = 0; j < col; j++) {
                    switch (mat[i][j]) {
                        case 'G' -> {
                            sr = i;
                            sc = j;
                        }
                        case 'H' -> {
                            er = i;
                            ec = j;
                            mat[i][j] = '#';
                        }
                        case '#' -> {
                            for (int k = 0; k < 4; k++) {
                                bmat[k][i][j] = true;
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (dir.indexOf(mat[i][j]) != -1) {
                        int d = dir.indexOf(mat[i][j]);
                        for (int k = 0; k < 4; k++, d = (d + 1) % 4) {
                            int r = i;
                            int c = j;
                            while (r >= 0 && r < row && c >= 0 && c < col && mat[r][c] != '#') {
                                bmat[k][r][c] = true;
                                r += vr[d];
                                c += vc[d];
                            }
                        }
                    }
                }
            }
            int[][][] smat = new int[4][row][col];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < row; j++) {
                    Arrays.fill(smat[i][j], Integer.MAX_VALUE);
                }
            }
            Queue<Integer> q = new LinkedList<>();
            if (!bmat[0][sr][sc]) {
                q.add(sr);
                q.add(sc);
                q.add(0);
                smat[0][sr][sc] = 0;
            }
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                int t = q.poll() % 4;
                if (!bmat[(t + 1) % 4][r][c] && smat[(t + 1) % 4][r][c] == Integer.MAX_VALUE) {
                    q.add(r);
                    q.add(c);
                    q.add((t + 1) % 4);
                    smat[(t + 1) % 4][r][c] = smat[t][r][c] + 1;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    if (rr >= 0 && rr < row && cc >= 0 && cc < col && !bmat[(t + 1) % 4][rr][cc] && smat[(t + 1) % 4][rr][cc] == Integer.MAX_VALUE) {
                        q.add(rr);
                        q.add(cc);
                        q.add((t + 1) % 4);
                        smat[(t + 1) % 4][rr][cc] = smat[t][r][c] + 1;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                min = Math.min(min, smat[i][er][ec]);
            }
            System.out.printf("Case #%d: %d\n", Tcase, min == Integer.MAX_VALUE ? -1 : min);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Guozhi().run();
    }
}