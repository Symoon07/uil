package region2009;

import java.util.*;
import java.io.*;

public class Realtor {
    public int getVal(int[][] mat, int sr, int sc, int r, int c) {
        int out = 0;
        for (int i = sr; i < r; i++) {
            for (int j = sc; j < c; j++) {
                out += mat[i][j];
            }
        }
        return out;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2009/Realtor.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int[][] mat = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = f.nextInt();
                }
            }
            int max = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    for (int k = i; k <= row; k++) {
                        for (int l = j; l <= col; l++) {
                            max = Math.max(max, getVal(mat, i, j, k, l));
                        }
                    }
                }
            }
            System.out.println(max);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Realtor().run();
    }

}