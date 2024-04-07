package region2010;

import java.util.*;
import java.io.*;

public class Encryption {

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/regional2010/encryption.dat"));
        int cases = file.nextInt();
        while (cases-- > 0) {
            String num = file.next();
            String out = "";
            for (int i = 0; i < num.length(); i+=4) {
                int one = Integer.parseInt(num.substring(i,i+1));
                int two = Integer.parseInt(num.substring(i+1,i+2));
                int three = Integer.parseInt(num.substring(i+2,i+3));
                int four = Integer.parseInt(num.substring(i+3,i+4));
                one = (one + 7) % 10;
                two = (two + 7) % 10;
                three = (three + 7) % 10;
                four = (four + 7) % 10;
                out +=  "" + three + four + one + two;
            }
            System.out.println(out);
        }
    }

    public static void main(String[] args) throws Exception {
        new Encryption().run();
    }

}