package region2011;

import java.util.*;
import java.io.*;

public class BlobTop {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2011/BlobTop.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int row = f.nextInt();
            int col = f.nextInt();
            int s = f.nextInt();
            char[][] mat = new char[row][col];
            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.next().toCharArray();
            }
            while (s-- > 0) {
                int sr = f.nextInt()-1;
                int sc = f.nextInt()-1;
                int or = Integer.MAX_VALUE;
                int oc = Integer.MAX_VALUE;
                Queue<Integer> q = new LinkedList<>();
                boolean[][] visited = new boolean[row][col];
                int[] vr = {0, 0, -1, 1};
                int[] vc = {-1, 1, 0, 0};
                q.add(sr);
                q.add(sc);
                while (!q.isEmpty()) {
                    int r = q.poll();
                    int c = q.poll();
                    if (r < 0 || r >= row || c < 0 || c >= col || visited[r][c] || mat[r][c] == '.') {
                        continue;
                    }
                    if (r < or) {
                        or = r;
                        oc = c;
                    }
                    if (r == or) {
                        oc = Math.min(oc, c);
                    }
                    for (int i = 0; i < 4; i++) {
                        int rr = r + vr[i];
                        int cc = c + vc[i];
                        q.add(rr);
                        q.add(cc);
                    }
                    visited[r][c] = true;
                }
                System.out.println(or == Integer.MAX_VALUE ? "NOT A BLOB" : or + 1 +  " " + (oc + 1));
            }
        }

        f.close();
    }
    public static void main(String[] args) throws Exception {
        new BlobTop().run();
    }

}