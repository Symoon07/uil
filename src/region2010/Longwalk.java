package region2010;

import java.util.*;
import java.io.*;

public class Longwalk {

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/regional2010/longwalk.dat"));
        int cases = file.nextInt();
        file.nextLine();
        while (cases-- > 0) {
            String street = file.nextLine();
            int n = file.nextInt();
            file.nextLine();
            int min = Integer.MAX_VALUE;
            int max = 0;
            while (n-- > 0) {
                int num = file.nextInt();
                file.nextLine();
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            System.out.println("The two houses farthest apart on " + street + " are");
            System.out.println(min + " " + street + " and " + max + " " + street);
        }
    }

    public static void main(String[] args) throws Exception {
        new Longwalk().run();
    }

}