package sammyp1;

import java.util.*;
import java.io.*;

public class Hovercraft {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/sammyp1/Hovercraft.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt();
            char[][] mat = new char[row][col];
            boolean[][] v = new boolean[row][col];
            int sr = 0, sc = 0;
            for (int i = 0; i < row; i++) {
                String s = f.next();
                mat[i] = s.toCharArray();
                if (s.contains("S")) {
                    sr = i;
                    sc = s.indexOf("S");
                }
            }
            int[] vr = {-1, 1, 0, 0, -1, -1, 1, 1};
            int[] vc = {0, 0, -1, 1, -1, 1, -1, 1};
            boolean found = false;
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            run : while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == '#' || v[r][c]) {
                    continue;
                }
                for (int i = 0; i < 8; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && mat[nr][nc] == '#') {
                        continue run;
                    }
                }
                if (mat[r][c] == 'E') {
                    found = true;
                    break;
                }
                v[r][c] = true;
                for (int i = 0; i < 8; i++) {
                    q.add(r + vr[i]);
                    q.add(c + vc[i]);
                }
            }
            System.out.println(found ? "WHOOSH" : "OUTDATED");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Hovercraft().run();
    }
}