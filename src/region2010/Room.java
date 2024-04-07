package region2010;

import java.util.*;
import java.io.*;

public class Room {
    char[][] mat;
    int cost;

    public void recur(int r, int c) {
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[r].length || mat[r][c] == '#') {
            return;
        }
        cost++;
        mat[r][c] = '#';
        recur(r, c+1);
        recur(r, c-1);
        recur(r+1, c);
        recur(r-1, c);
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/regional2010/room.dat"));
        int cases = file.nextInt();
        while (cases-- > 0) {
            int row = file.nextInt();
            int col = file.nextInt();
            int sr = 0;
            int sc = 0;
            mat = new char[row][col];
            for (int i = 0; i < row; i++) {
                String s = file.next();
                for (int j = 0; j < col; j++) {
                    mat[i][j] = s.charAt(j);
                    if (mat[i][j] == '@') {
                        sr = i;
                        sc = j;
                    }
                }
            }
            cost = 0;
            recur(sr, sc);
            System.out.println("$" + cost);
        }
    }

    public static void main(String[] args) throws Exception {
        new Room().run();
    }

}