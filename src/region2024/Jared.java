package region2024;

import java.util.*;
import java.io.*;

public class Jared {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/region2024/Jared.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String[] in = f.nextLine().split(",");
            int out = 0;
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < in.length; j++) {
                    if (i != j && in[i].startsWith(in[j])) {
                        out++;
                    }
                }
            }
            System.out.println(out == 0 ? "Democracy Prevails!" : "There are " + out + " misinputs...");
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Jared().run();
    }
}