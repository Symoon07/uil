package region2021;

import java.util.*;
import java.io.*;

public class Bruce {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2021/Bruce.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t-- > 0) {
            int n = f.nextInt();
            System.out.printf("%.4f\n", Math.sqrt(n) * 4);
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Bruce().run();
    }
}