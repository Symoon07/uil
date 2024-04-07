package region2013;

import java.util.*;
import java.io.*;

public class Thirteen {
    char[][] mat;
    int out;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/Thirteen.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            mat = new char[10][10];
            out = Integer.MAX_VALUE;
            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.next().toCharArray();
            }
            recur(0, 0, 0, 0);
            System.out.println(out);
        }

        f.close();
    }

    public void recur(int r, int c, int s, int j) {
        if (r < 0 || r >= 10 || c < 0 || c >= 10 || mat[r][c] == '#' || s >= out) {
            return;
        }
        int[] vr = {-1, 1, 0, 0};
        int[] vc = {0, 0, -1, 1};
        if (mat[r][c] == 'E' && j == 13) {
            out = s;
            return;
        }
        char save = mat[r][c];
        if (mat[r][c] == '*') {
            mat[r][c] = '#';
            for (int i = 0; i < 4; i++) {
                recur(r + vr[i], c + vc[i], s+1, j+1);
            }
        }
        else {
            mat[r][c] = '#';
            for (int i = 0; i < 4; i++) {
                recur(r + vr[i], c + vc[i], s+1, j);
            }
        }
        mat[r][c] = save;
    }

    public static void main(String[] args) throws Exception {
        new Thirteen().run();
    }

}