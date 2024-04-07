package region2012;

import java.util.*;
import java.io.*;

public class PetitePals {

    public boolean isPali(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/PetitePals.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            HashSet<String> hs = new HashSet<>();
            String word = f.next();
            for (int i = 0; i < word.length(); i++) {
                for (int j = i + 1; j < word.length() + 1; j++) {
                    if (isPali(word.substring(i, j)) && word.substring(i, j).length() < word.length()) {
                        hs.add(word.substring(i, j));
                    }
                }
            }
            System.out.println(hs.size());
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new PetitePals().run();
    }

}