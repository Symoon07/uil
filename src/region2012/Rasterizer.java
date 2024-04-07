package region2012;

import java.util.*;
import java.io.*;

public class Rasterizer {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/Rasterizer.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int c = f.nextInt();
            int r = f.nextInt(); f.nextLine();
            char[][] mat = new char[r][c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(mat[i], '.');
            }
            while (f.hasNext()) {
                String[] line = f.nextLine().split(" ");
                if (line[0].equals("END")) {
                    break;
                }
                switch (line[0]) {
                    case "BOX" -> box(mat, line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6]);
                    case "LINE" -> line(mat, line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                    case "CROSS" -> cross(mat, line[1], Integer.parseInt(line[3]), Integer.parseInt(line[2]), Integer.parseInt(line[4]), Integer.parseInt(line[5]));
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public void box(char[][] mat, String c, int x1, int y1, int x2, int y2, String fill) {
        for (int i = y1;i < mat.length && i <= y2; i++) {
            if (i >= 0) {
                for (int j = x1;j < mat[i].length && j <= x2; j++) {
                    if (fill.equals("Y") && j >= 0) {
                        mat[i][j] = c.charAt(0);
                    }
                    else {
                        if (i == y1 || i == y2 || j == x1 || j == x2) {
                            mat[i][j] = c.charAt(0);
                        }
                    }
                }
            }
        }
    }

    public void line(char[][] mat, String c, int x1, int y1, int x2, int y2) {
        for (int i = y1;i < mat.length && i <= y2; i++) {
            if (i >= 0) {
                for (int j = x1;j < mat[i].length && j <= x2; j++) {
                    if (j >= 0) {
                        mat[i][j] = c.charAt(0);
                    }
                }
            }
        }
    }

    public void cross(char[][] mat, String c, int cx, int cy, int w, int h) {
        int x1 = w % 2 == 1 ? (w - 1) / 2 : w / 2 - 1;
        int x2 = w % 2 == 1 ? (w - 1) / 2 : w / 2;
        int y1 = h % 2 == 1 ? (h - 1) / 2 : h / 2 - 1;
        int y2 = h % 2 == 1 ? (h - 1) / 2 : h / 2;
        for (int i = cx - x1;i < mat.length && i <= cx + x2; i++) {
            if (i >= 0) {
                mat[i][cy] = c.charAt(0);
            }
        }
        for (int j = cy - y1;j < mat[cx].length && j <= cy + y2; j++) {
            if (j >= 0) {
                mat[cx][j] = c.charAt(0);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Rasterizer().run();
    }

}