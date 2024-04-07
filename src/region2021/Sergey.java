package region2021;

import java.util.*;
import java.io.*;

public class Sergey {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2021/Sergey.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int l = f.nextInt(), d = f.nextInt() % 360 / 90;
            char[][] mat = new char[l][l];
            for (int i = 0; i < l; i++) {
                mat[i] = f.next().toCharArray();
            }
            for (int i = 0; i < d; i++) {
                char[][] nmat = new char[l][l];
                for (int j = 0; j < l; j++) {
                    for (int k = 0; k < l; k++) {
                        nmat[j][k] = mat[l - k - 1][j];
                    }
                }
                mat = nmat;
            }
            for (int i = 0; i < l; i++) {
                System.out.println(mat[i]);
            }
            System.out.println("DONE");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Sergey().run();
    }
}