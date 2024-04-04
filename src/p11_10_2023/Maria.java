package p11_10_2023;

import java.util.*;
import java.io.*;

public class Maria {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("maria.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNextInt()) {

            int face = f.nextInt();
            if (face == 1) {
                System.out.println("---\n" +
                        "-*-\n" +
                        "---\n");
            }
            else if (face == 2) {
                System.out.println("*--\n" +
                        "---\n" +
                        "--*\n");
            }
            else if (face == 3) {
                System.out.println("*--\n" +
                        "-*-\n" +
                        "--*\n");
            }
            else if (face == 4) {
                System.out.println("*-*\n" +
                        "---\n" +
                        "*-*\n");
            }
            else if (face == 5) {
                System.out.println("*-*\n" +
                        "-*-\n" +
                        "*-*\n");
            }
            else {
                System.out.println("*-*\n" +
                        "*-*\n" +
                        "*-*");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Maria().run();
    }

}