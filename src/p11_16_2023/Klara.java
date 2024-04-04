package p11_16_2023;

import java.util.*;
import java.io.*;

public class Klara {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Klara.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            int n = f.nextInt();
            char[][] mat = new char[n][n];
            for (int i = 0; i < n; i++) {
                mat[i] = f.next().toCharArray();
            }
            char save = mat[n / 2][n / 2];
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(n / 2);
            q.add(n / 2);
            while (!q.isEmpty()) {
                int r = q.poll(), c = q.poll();
                if (r < 0 || r>= n || c < 0 || c >= n || mat[r][c] != save) {
                    continue;
                }
                mat[r][c] = '-';
                for (int i = 0; i < 4; i++) {
                    q.add(r + vr[i]);
                    q.add(c + vc[i]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println("=====");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Klara().run();
    }

}