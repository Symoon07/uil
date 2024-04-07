package region2001;

import java.util.*;
import java.io.*;

public class Checkers {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2001/Checkers.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            char[][] mat = new char[8][8];
            for (int i = 0; i < mat.length; i++) {
                mat[i] = f.nextLine().toCharArray();
            }
            int or = 0;
            int oc = 0;
            int max = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (mat[i][j] == 'R') {
                        int[] vr = {-2, -2};
                        int[] vc = {-2, 2};
                        Queue<Integer> q = new LinkedList<>();
                        q.add(i);
                        q.add(j);
                        q.add(0);
                        while (!q.isEmpty()) {
                            int r = q.poll();
                            int c = q.poll();
                            int m = q.poll();
                            if (m > max) {
                                or = i;
                                oc = j;
                                max = m;
                            }
                            for (int k = 0; k < 2; k++) {
                                int rr = r + vr[k];
                                int cc = c + vc[k];
                                int brr = r + vr[k] / 2;
                                int bcc = c + vc[k] / 2;
                                if (rr >= 0 && rr < 8 && cc >= 0 && cc < 8 && brr >= 0 && brr < 8 && bcc >= 0 && bcc < 8) {
                                    if (mat[brr][bcc] == 'B' && mat[rr][cc] == ' ') {
                                        q.add(rr);
                                        q.add(cc);
                                        q.add(m+1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(or + " " + oc + " " + max);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Checkers().run();
    }

}