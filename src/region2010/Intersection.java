package region2010;

import java.util.*;
import java.io.*;

public class Intersection {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2010/intersection.dat"));
        int cases = f.nextInt(); f.nextLine();
        while (cases-- > 0) {
            int datas = f.nextInt(); f.nextLine();
            TreeSet<Integer> total = new TreeSet<>();
            int[][] mat = new int[datas][];
            for (int i = 0; i < datas; i++) {
                String[] line = f.nextLine().split(" ");
                for (String num : line) {
                    total.add(Integer.parseInt(num));
                }
                mat[i] = new int[line.length];
                for (int j = 0; j < line.length; j++) {
                    mat[i][j] = Integer.parseInt(line[j]);
                }
            }
            for (int i = 0; i < datas; i++) {
                TreeSet<Integer> cur = new TreeSet<>();
                for (int j = 0; j < mat[i].length; j++) {
                    cur.add(mat[i][j]);
                }
                total.retainAll(cur);
            }
            if (total.isEmpty()) {
                System.out.println("NO COMMON ELEMENT FOUND");
            }
            else {
                for (int num : total) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Intersection().run();
    }

}