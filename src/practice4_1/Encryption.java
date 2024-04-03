package practice4_1;

import java.util.*;
import java.io.*;

public class Encryption {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Encryption.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        while (t --> 0) {
            int n = f.nextInt();
            String s = f.nextLine().trim();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    System.out.print(" ");
                }
                else {
                    System.out.print(alpha.charAt((alpha.indexOf(s.charAt(i)) + 26 + n) % 26));
                }
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Encryption().run();
    }

}