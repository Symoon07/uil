package district2024;

import java.util.*;
import java.io.*;

public class Veda {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/district2024/Veda.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        HashMap<String, Double> hm = new HashMap<>();
        while (t --> 0) {
            String[] in = f.nextLine().split("[,:]");
            for (int i = 0; i < in.length - 1; i++) {
                hm.put(in[i], Double.parseDouble(in[in.length - 1]));
            }
        }
        t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String in = f.nextLine();
            double out = 0;
            for (int i = 0; i < in.length(); i++) {
                if (Character.isAlphabetic(in.charAt(i))) {
                    out += hm.get("" + in.charAt(i));
                }
            }
            System.out.printf("$%.2f\n", out);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Veda().run();
    }
}