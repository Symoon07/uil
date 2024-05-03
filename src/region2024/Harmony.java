package region2024;

import java.util.*;
import java.io.*;

public class Harmony {
    String s;
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/region2024/Harmony.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        String a = f.next();
        s = f.next();
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] in = f.next().split(",");
            l.addAll(Arrays.asList(in).subList(0, 10));
        }
        while (f.hasNext()) {
            String p = f.next();
            int sum = 0;
            int[] has = new int[4];
            for (int i = 0; i < p.length(); i++) {
                has[getC(p.charAt(i))] = 1;
            }
            sum += has[0] + has[1] + has[2] + has[3];
            if (l.contains(p) || p.length() < 8 || sum < 3) {
                System.out.println(p + ":0:UNACCEPTABLE");
                continue;
            }
            int out = 0;
            for (int i = 0; i < p.length(); i++) {
                if (getC(p.charAt(i)) == 3) {
                    out += 5;
                }
                else if (getC(p.charAt(i)) == 2) {
                    out += 3;
                }
                else {
                    out += a.indexOf(p.substring(i, i + 1).toUpperCase()) < 13 ? 1 : 3;
                }
            }
            if (sum == 4) {
                out += 5;
            }
            if (p.length() > 10) {
                out += 3 * (p.length() - 10);
            }
            for (int i = 0; i < p.length() - 1; i++) {
                if (getC(p.charAt(i)) != getC(p.charAt(i + 1))) {
                    out += 3;
                }
                if (p.charAt(i) == p.charAt(i + 1)) {
                    out -= 2;
                }
            }
            String w = "";
            if (out <= 0) {
                w = "UNACCEPTABLE";
            }
            else if (out <= 20) {
                w = "WEAK";
            }
            else if (out <= 35) {
                w = "FAIR";
            }
            else if (out <= 50) {
                w = "GOOD";
            }
            else {
                w = "STRONG";
            }
            System.out.printf("%s:%d:%s%n", p, out, w);
        }

        f.close();
    }

    public int getC(char c) {
        if (Character.isUpperCase(c)) {
            return 0;
        }
        if (Character.isLowerCase(c)) {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        if (s.contains("" + c)) {
            return 3;
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        new Harmony().run();
    }

}