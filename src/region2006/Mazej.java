package region2006;

import java.util.*;
import java.io.*;

public class Mazej {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2006/Mazej.in".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int col = f.nextInt();
            int row = f.nextInt();
            int sr = -1;
            int sc = -1;
            char[][] mat = new char[row][col];
            char[][] out = new char[row][col];
            for (int i = 0; i < row; i++) {
                String s = f.next();
                for (int j = 0; j < col; j++) {
                    mat[i][j] = s.charAt(j);
                    out[i][j] = s.charAt(j);
                    if (mat[i][j] == '@' && sr == -1) {
                        sr = i;
                        sc = j;
                    }
                }
            }
            int[] vr = {-1, 1, 0, 0};
            int[] vc = {0, 0, -1, 1};
            Queue<ArrayList<Integer>> q = new LinkedList<>();
            ArrayList<Integer> path = new ArrayList<>();
            path.add(sr);
            path.add(sc);
            q.add(path);
            while (!q.isEmpty()) {
                ArrayList<Integer> cur = q.poll();
                int r = cur.get(0);
                int c = cur.get(1);
                if (r < 0 || r >= row || c < 0 || c >= col || mat[r][c] == '#') {
                    continue;
                }
                if (mat[r][c] == '@') {
                    path = cur;
                }
                for (int i = 0; i < 4; i++) {
                    int rr = r + vr[i];
                    int cc = c + vc[i];
                    ArrayList<Integer> next = new ArrayList<>(cur);
                    next.addFirst(cc);
                    next.addFirst(rr);
                    q.add(next);
                }
                mat[r][c] = '#';
            }
            for (int i = 0; i < path.size(); i+=2) {
                out[path.get(i)][path.get(i+1)] = '@';
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(out[i][j]);
                }
                System.out.println();
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Mazej().run();
    }

}