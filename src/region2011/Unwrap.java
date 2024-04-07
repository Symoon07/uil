package region2011;

import java.util.*;
import java.io.*;

public class Unwrap {
    int[][] mat;
    boolean[][] visited;
    ArrayList<Integer> l;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2011/Unwrap.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        mat = new int[n][n];
        visited = new boolean[n][n];
        l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = f.nextInt();
            }
        }
        go(0, 0, 0, 1);
        for (int i = 0; i < l.size(); i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(l.get(i) + " ");
        }

        f.close();
    }

    public void go (int r, int c, int rv, int cv) {
            if (r < 0 || r >= mat.length || c < 0 || c >= mat.length || visited[r][c]) {
                return;
            }
            visited[r][c] = true;
            l.add(mat[r][c]);
            if (r+rv < 0 || r+rv >= mat.length || c+cv < 0 || c+cv >= mat.length || visited[r+rv][c+cv]) {
                go(r, c+1, 0, 1); //right
                go(r+1, c, 1, 0); //down
                go(r, c-1, 0, -1); //left
                go(r-1, c, -1, 0); //up
            }
            else {
                go(r+rv, c+cv, rv, cv);
            }
        }

    public static void main(String[] args) throws Exception {
        new Unwrap().run();
    }

}