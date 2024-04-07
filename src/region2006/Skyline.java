package region2006;

import java.util.*;
import java.io.*;

public class Skyline {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2006/Skyline.in".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int dim = f.nextInt();
            char[][] mat = new char[dim][dim];
            for (int i = 0; i < dim; i++) {
                String s = f.next();
                for (int j = 0; j < dim; j++) {
                    mat[i][j] = s.charAt(j);
                }
            }
            char[][] out = new char[dim][dim];
            for (int i = 0; i < dim; i++) {
                for (int j = 0; j < dim; j++) {
                    if (mat[i][j] != '0') {
                        int dis = j+1;
                        int height = Integer.parseInt(String.valueOf(mat[i][j]));
                        for (int k = dim - height; k < dim; k++) {
                            out[k][i] = Character.forDigit(dis, 10);
                        }
                    }
                }
            }
            for (char[] row : out)
                System.out.println(Arrays.toString(row));
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Skyline().run();
    }

}