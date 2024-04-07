package region2013;

import java.util.*;
import java.io.*;

public class Waitlist {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/waitlist.dat"));
        //Scanner f = new Scanner(System.in);

        int events = f.nextInt();
        for (int i = 0; i < events; i++) {

            String event = f.next();
            int max = f.nextInt();
            int reg = f.nextInt();
            if (max < reg) {
                System.out.println(event + " " + (reg - max));
            }
            else {
                System.out.println(event + " 0");
            }

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Waitlist().run();
    }

}