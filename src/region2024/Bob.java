package region2024;

import java.util.*;
import java.io.*;

public class Bob {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/region2024/Bob.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(val);
            System.out.println(val[0] * val[1] + val[2] + val[3] * val[4]);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Bob().run();
    }
}