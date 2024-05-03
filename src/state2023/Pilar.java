package state2023;

import java.util.*;
import java.io.*;

public class Pilar {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/state2023/Pilar.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            String[] in = f.next().split("[,:]");
            int l1 = Integer.parseInt(in[0]), u1 = Integer.parseInt(in[1]), l2 = Integer.parseInt(in[2]), u2 = Integer.parseInt(in[3]), l3 = Integer.parseInt(in[4]), u3 = Integer.parseInt(in[5]);
            double[][][] mat = new double[u1 - l1 + 1][u2 - l2 + 1][u3 - l3 + 1];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    mat[i][j] = Arrays.stream(f.next().split(",")).mapToDouble(Double::parseDouble).toArray();
                }
            }
            int n = f.nextInt();
            while (n --> 0) {
                String[] s = f.next().split("[,:]");
                int ll1 = Integer.parseInt(s[0]) - l1, uu1 = Integer.parseInt(s[1]) - l1, ll2 = Integer.parseInt(s[2]) - l2, uu2 = Integer.parseInt(s[3]) - l2, ll3 = Integer.parseInt(s[4]) - l3, uu3 = Integer.parseInt(s[5]) - l3;
                int ct = (uu1 - ll1 + 1) * (uu2 - ll2 + 1) * (uu3 - ll3 + 1);
                double sum = 0;
                for (int i = ll1; i <= uu1; i++) {
                    for (int j = ll2; j <= uu2; j++) {
                        for (int k = ll3; k <= uu3; k++) {
                            sum += mat[i][j][k];
                        }
                    }
                }
                System.out.printf("%d:%.2f%n", ct, sum);
            }
            System.out.println("=".repeat(20));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Pilar().run();
    }
}