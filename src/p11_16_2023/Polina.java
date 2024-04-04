package p11_16_2023;

import java.util.*;
import java.io.*;

public class Polina {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Polina.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String[] line = f.nextLine().split(" ");
            StringBuilder s = new StringBuilder(line[0]);
            for (int i = 1; i < line.length; i++) {
                String hex = Integer.toHexString(Integer.parseInt(line[i])).toUpperCase();
                if (Integer.parseInt(line[i].substring(0,1)) % 2 == 0) {
                    char save = s.charAt(Integer.parseInt(line[i].substring(1,2))-1);
                    s.setCharAt(Integer.parseInt(line[i].substring(1,2))-1, s.charAt(Integer.parseInt(line[i].substring(2,3))-1));
                    s.setCharAt(Integer.parseInt(line[i].substring(2,3))-1, save);
                }
                else {
                    char save = s.charAt(s.length()-Integer.parseInt(line[i].substring(1,2)));
                    s.setCharAt(s.length()-Integer.parseInt(line[i].substring(1,2)), s.charAt(s.length()-Integer.parseInt(line[i].substring(2,3))));
                    s.setCharAt(s.length()-Integer.parseInt(line[i].substring(2,3)), save);
                }
                if (i == 1) {
                    s.insert(0, "A");
                    s.insert(s.length(), "AA");
                }
                s.insert(0, hex.charAt(0));
                s.insert(s.length(), hex.charAt(2));
            }
            System.out.println(line[0] + " " + s);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Polina().run();
    }

}