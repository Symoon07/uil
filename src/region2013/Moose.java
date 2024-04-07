package region2013;

import java.util.*;
import java.io.*;

public class Moose {
    char[][] mat;
    int maxSize;

    public int recur(int r, int c) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] != 'M') return 0;

        mat[r][c] = '.';
        int size = 1;
        size += recur(r+1, c);
        size += recur(r-1, c);
        size += recur(r, c+1);
        size += recur(r, c-1);

        return size;
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/moose.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            mat = new char[10][10];
            maxSize = 0;
            for (int i = 0; i < 10; i++) {
                mat[i] = f.next().toCharArray();
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (mat[i][j] == 'M') {
                        maxSize = Math.max(maxSize, recur(i, j));
                    }
                }
            }

            System.out.println(maxSize);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Moose().run();
    }

}