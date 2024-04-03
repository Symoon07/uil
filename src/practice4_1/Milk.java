package practice4_1;

import java.util.*;
import java.io.*;

public class Milk {
    char[][] mat;
    int[][] smat;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Milk.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt(), S = f.nextInt();
            mat = new char[row][col];
            smat = new int[row][col];
            int sr = 0, sc = 0, mr = -1, mc = -1;
            for (int i = 0; i < row; i++) {
                String temp = f.next();
                mat[i] = temp.toCharArray();
                Arrays.fill(smat[i], Integer.MAX_VALUE);
                if (temp.contains("S")) {
                    sr = i;
                    sc = temp.indexOf("S");
                }
                if (temp.contains("M")) {
                    mr = i;
                    mc = temp.indexOf("M");
                }
            }
            recur(sr, sc, 0);
            if (mr != -1 && smat[mr][mc] <= S) {
                System.out.println("Everything's peachy, Spidey escaped in " + smat[mr][mc] + " seconds.");
            }
            else {
                System.out.println("Spidey's having marital problems.");
            }
        }

        f.close();
    }

    public void recur(int r, int c, int s) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || s >= smat[r][c]) {
            return;
        }
        smat[r][c] = s;
        switch (mat[r][c]) {
            case '.', 'S' -> s += 1;
            case '#' -> s += 3;
            case 'D', 'V', 'C' -> s += 8;
            default -> s += 5;
        }
        for (int i = 0; i < 4; i++) {
            recur(r + vr[i], c + vc[i], s);
        }
    }

    public static void main(String[] args) throws Exception {
        new Milk().run();
    }
}