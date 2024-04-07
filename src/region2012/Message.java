package region2012;

import java.util.*;
import java.io.*;

public class Message {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/Message.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt(); f.nextLine();
        while (n-- > 0) {
            int m = f.nextInt(); f.nextLine();
            String[] line = f.nextLine().replaceAll("\\.", "").replaceAll(",", "").split(" ");
            for (int i = 0; i < line.length; i++) {
                if (line[i].length() == m) {
                    System.out.print(line[i] + " ");
                }
            }
            System.out.println();
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Message().run();
    }

}