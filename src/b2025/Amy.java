package b2025;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Amy {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Amy.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            BigInteger n = new BigInteger("36");
            n = n.pow(f.next().length());
            n = n.divide(new BigInteger(f.next()));
            System.out.println(n);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Amy().run();
    }

}