package region2012;

import java.util.*;
import java.io.*;

public class Etch {
    static int r;
    static int c;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/Etch.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            char[][] mat = new char[15][25];
            for (int i = 0; i < mat.length; i++) {
                Arrays.fill(mat[i], '.');
            }
            r = f.nextInt() - 1;
            c = f.nextInt() - 1; f.nextLine();
            mat[r][c] = '*';
            String[] line = f.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                char dir = line[i].charAt(0);
                int num = Integer.parseInt(line[i].substring(1));
                switch (dir) {
                    case 'R'-> right(mat, num);
                    case 'L'-> left(mat, num);
                    case 'U'-> up(mat, num);
                    case 'D'-> down(mat, num);
                }
            }
            for (int i = 0; i < 15; i++) {
                for (int j = 0; j < 25; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public void right(char[][] mat, int n) {
        int i;
        for (i = 0; c + i + 1 < 25 && i < n; i++) {
            mat[r][c+i+1] = '*';
        }
        c += i;
    }

    public void left(char[][] mat, int n) {
        int i;
        for (i = 0; c - i > 0 && i < n; i++) {
            mat[r][c-i-1] = '*';
        }
        c -= i;
    }

    public void down(char[][] mat, int n) {
        int i;
        for (i = 0; r + i + 1 < 15 && i < n; i++) {
            mat[r+i+1][c] = '*';
        }
        r += i;
    }

    public void up(char[][] mat, int n) {
        int i;
        for (i = 0; r - i > 0 && i < n; i++) {
            mat[r-i-1][c] = '*';
        }
        r -= i;
    }

    public static void main(String[] args) throws Exception {
        new Etch().run();
    }

}