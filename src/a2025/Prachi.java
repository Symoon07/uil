package a2025;

import java.util.*;
import java.io.*;

public class Prachi {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2025/Prachi.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t-- > 0) {
            int row = f.nextInt(), col = f.nextInt(), sr = f.nextInt(), sc = f.nextInt();
            char[][] m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.next().toCharArray();
            }
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sr);
            q.add(sc);
            while (!q.isEmpty()) {
                int r = q.poll();
                int c = q.poll();
                if (r < 0 || r >= row || c < 0 || c >= col || m[r][c] != '.') {
                    continue;
                }
                m[r][c] = '$';
                for (int i = 0; i < 4; i++) {
                    q.add(r + vr[i]);
                    q.add(c + vc[i]);
                }
            }
            for (int i = 0; i < row; i++) {
                System.out.println(m[i]);
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Prachi().run();
    }

}