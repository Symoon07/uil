package p4_1_2024;

import java.util.*;
import java.io.*;

public class Recon {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Recon.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt();
            char[][] mat = new char[row][col];
            boolean[][] v = new boolean[row][col];
            int sr = 0, sc = 0, kr = 0, kc = 0, xr = 0, xc = 0;
            for (int i = 0; i < row; i++) {
                String s = f.next();
                mat[i] = s.toCharArray();
                if (s.contains("S")) {
                    sr = i;
                    sc = s.indexOf("S");
                }
                if (s.contains("K")) {
                    kr = i;
                    kc = s.indexOf("K");
                }
                if (s.contains("X")) {
                    xr = i;
                    xc = s.indexOf("X");
                }
            }
            int[] vr = {-1, 1, 0, 0, -1, 1, -1, 1};
            int[] vc = {0, 0, -1, 1, -1, -1, 1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == '#' || v[r][c]) {
                    continue;
                }
                v[r][c] = true;
                for (int i = 0; i < 8; i++) {
                    q.add(r + vr[i]);
                    q.add(c + vc[i]);
                }
            }
            System.out.println(v[kr][kc] && v[xr][xc] ? "YA HIRED" : "YA FIRED");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Recon().run();
    }

}