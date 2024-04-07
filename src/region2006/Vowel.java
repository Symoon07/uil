package region2006;

import java.io.*;
import java.util.*;

public class Vowel {

    public static void main(String[] args) throws Exception {
        new Vowel().run();
    }

    public void run() throws Exception {
        Scanner file = new Scanner(new File("Data/regional2006/vowel.in"));
        //Scanner file = new Scanner(System.in);

        String vowels = "AEIOUaeiou";
        int cases = file.nextInt();
        while (cases-- > 0) {

            String word = file.next();
            if (vowels.indexOf(word.charAt(0)) == -1) {
                System.out.println("The word '" + word + "' begins with a consonant.");
            }
            else {
                System.out.println("The word '" + word + "' begins with a vowel.");
            }
        }

        file.close();
    }
}