package p11_16_2023;

import java.util.*;
import java.io.*;

public class Deshi {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Deshi.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
            String s = f.next();
            System.out.println(s.matches(".*[aeiou]{5}.*") || s.matches(".*[^aeiou]{8}.*") ? "NOT ACCEPTABLE " + s : "ACCEPTABLE " + s);
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Deshi().run();
    }

}