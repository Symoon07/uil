package region2013;

import java.util.*;
import java.io.*;

public class Maze3D {
    char[][][] mat;
    int moves;
    int mag;

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/maze3d.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int rows = f.nextInt();
            int cols = f.nextInt();
            int floors = f.nextInt();
            int sf = 0;
            int sr = 0;
            int sc = 0;
            mat = new char[floors][rows][cols];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    mat[i][j] = f.next().toCharArray();
                    for (int k = 0; k < mat[i][j].length; k++) {
                        if (mat[i][j][k] == 'S') {
                            sf = i;
                            sr = j;
                            sc = k;
                        }
                    }
                }
            }

            mag = 3;
            moves = -1;
            int[] vr = {-1, 1, 0, 0, 0, 0};
            int[] vc = {0, 0, -1, 1, 0, 0};
            int[] vf = {0, 0, 0, 0, -1, 1};
            Queue<Integer> q = new LinkedList<>();
            q.add(sf);
            q.add(sr);
            q.add(sc);
            q.add(0);
            q.add(mag);
            while (!q.isEmpty()) {
                int fl = q.poll();
                int r = q.poll();
                int c = q.poll();
                int steps = q.poll();
                int m = q.poll();
                if (fl < 0 || fl >= floors || r < 0 || r >= rows || c < 0 || c >= cols || mat[fl][r][c] == '#' || (m == 0 && mat[fl][r][c] == '*')) continue;

                if (mat[fl][r][c] == 'E') {
                    moves = steps;
                    break;
                }

                if (mat[fl][r][c] == '*') {
                    m--;
                }

                for (int i = 0; i < 6; i++) {
                    int ff = fl + vf[i];
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    q.add(ff);
                    q.add(rr);
                    q.add(cc);
                    q.add(steps + 1);
                    q.add(m);
                }
                mat[fl][r][c] = '#';

            }

            System.out.println(moves != -1 ? moves + " MOVES" : "STUCK");

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Maze3D().run();
    }

}