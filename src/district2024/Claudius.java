package district2024;

import java.util.*;
import java.io.*;

public class Claudius {
    char[][] mat;
    int[][] smat;
    int[] vr = {-1, 1, 0, 0};
    int[] vc = {0, 0, -1, 1};
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Claudius.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int row = f.nextInt(), col = f.nextInt(), hour = f.nextInt();
            mat = new char[row][col];
            smat = new int[row][col];
            int sr = 0, sc = 0, er = 0, ec = 0;
            for (int i = 0; i < row; i++) {
                mat[i] = f.next().toCharArray();
                Arrays.fill(smat[i], Integer.MAX_VALUE);
                for (int j = 0; j < col; j++) {
                    switch (mat[i][j]) {
                        case 'S' -> {
                            sr = i;
                            sc = j;
                        }
                        case 'E' -> {
                            er = i;
                            ec = j;
                        }
                        case 'R', 'V' -> mat[i][j] = '#';
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 'Q') {
                        boolean changed = false;
                        for (int k = 0; k < 4; k++) {
                            if (i + vr[k] >= 0 && i + vr[k] < row && j + vc[k] >= 0 && j + vc[k] < col && mat[i + vr[k]][j + vc[k]] == 'T') {
                                changed = true;
                            }
                        }
                        mat[i][j] = changed ? 'M' : '#';
                    }
                    if (mat[i][j] == 'A') {
                        for (int k = -1; k <= 1; k++) {
                            for (int l = -1; l <= 1; l++) {
                                if (i + k >= 0 && i + k < row && j + l >= 0 && j + l < col) {
                                    mat[i + k][j + l] = '#';
                                }
                            }
                        }
                    }
                    if (mat[i][j] == 'B') {
                        for (int k = -2; k <= 2; k++) {
                            for (int l = -2; l <= 2; l++) {
                                if (i + k >= 0 && i + k < row && j + l >= 0 && j + l < col) {
                                    mat[i + k][j + l] = '#';
                                }
                            }
                        }
                    }
                }
            }
            go(sr, sc, 0);
            System.out.println(smat[er][ec] <= hour ? "Free at last, Free at last. " + (hour - smat[er][ec]) + " hour(s) to spare." : "Smokey the Bear is en route.");
        }

        f.close();
    }

    public void go(int r, int c, int h) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == '#' || h >= smat[r][c]) {
            return;
        }
        smat[r][c] = h;
        int inc = 1;
        if (mat[r][c] == 'T') {
            inc = 2;
        }
        if (mat[r][c] == 'M') {
            inc = 3;
        }
        for (int i = 0; i < 4; i++) {
            go(r + vr[i], c + vc[i], h + inc);
        }
    }

    public static void main(String[] args) throws Exception {
        new Claudius().run();
    }
}