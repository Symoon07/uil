package district2024;

import java.util.*;
import java.io.*;

public class Caroline {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Caroline.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            for (int i = 0; i < val.length; i++) {
                sum += val[i] % 2 == 0 ? val[i] : -val[i];
            }
            if (sum == 0) {
                System.out.println("It's a tie!!!");
            }
            else {
                System.out.println(sum > 0 ? "Evens win by " + sum + " point(s)" : "Odds win by " + Math.abs(sum) + " point(s)");
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Caroline().run();
    }
}