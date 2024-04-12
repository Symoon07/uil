package a2022;

import java.util.*;
import java.io.*;

public class Renata {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2022/Renata.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0;
        while (tcase++ < t) {
            int n = f.nextInt();
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            int out = 0;
            n = f.nextInt();
            while (n --> 0) {
                int r = f.nextInt() - 1, c = f.nextInt() - 1;
                out += mat[r][c];
            }
            System.out.println(tcase + ": " + out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Renata().run();
    }

}