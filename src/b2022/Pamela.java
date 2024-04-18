package b2022;

import java.util.*;
import java.io.*;

public class Pamela {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Pamela.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0;
        while (tcase++ < t) {
            int row = f.nextInt(), col = f.nextInt();
            int[][] mat = new int[row][col];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = f.nextInt();
                    min = Math.min(min, mat[i][j]);
                    max = Math.max(max, mat[i][j]);
                }
            }
            int[] rSums = new int[row], rMins = new int[row], cSums = new int[col], cMaxs = new int[col];
            Arrays.fill(rMins, Integer.MAX_VALUE);
            Arrays.fill(cMaxs, Integer.MIN_VALUE);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    rSums[i] += mat[i][j];
                    cSums[j] += mat[i][j];
                    rMins[i] = Math.min(rMins[i], mat[i][j]);
                    cMaxs[j] = Math.max(cMaxs[j], mat[i][j]);
                }
            }
            System.out.println("Case: " + tcase);
            System.out.print("Row Sums:");
            for (int i = 0; i < row; i++) {
                System.out.printf("%7d", rSums[i]);
            }
            System.out.printf("%nRow Mins:");
            for (int i = 0; i < row; i++) {
                System.out.printf("%7d", rMins[i]);
            }
            System.out.printf("%nCol Sums:");
            for (int i = 0; i < col; i++) {
                System.out.printf("%7d", cSums[i]);
            }
            System.out.printf("%nCol Maxs:");
            for (int i = 0; i < col; i++) {
                System.out.printf("%7d", cMaxs[i]);
            }
            System.out.printf("%nMin Mins:%7d%nMax Maxs:%7d%n", min, max);
            System.out.println("=".repeat(20));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Pamela().run();
    }
}