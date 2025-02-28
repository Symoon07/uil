package a2025;

import java.util.*;
import java.io.*;

public class Anisha {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2025/Anisha.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t-- > 0) {
            System.out.println(f.nextInt() >= 15 ? "Way to go, H2O." : "On my way to Dehydration Station.");
            f.nextInt();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Anisha().run();
    }

}