package region2010;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Mathabet {
    public class Word implements Comparable<Word> {
        String name;
        String val;
        boolean prime;
        boolean even;

        public Word(String n) {
            name = n;
            val = "";
            prime = false;
            even = false;

            for (int i = 0; i < name.length(); i++) {
                val += (name.charAt(i) - 'a' + 1);
            }

            BigInteger one = new BigInteger(this.val);
            if (one.isProbablePrime(10)) {
                prime = true;
            }
            if (Integer.parseInt(val) % 2 == 0) {
                even = true;
            }
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Word o) {
            if (this.prime && !o.prime) {
                return 1;
            }
            if (!this.prime && o.prime) {
                return -1;
            }
            if (this.even && !o.even) {
                return 1;
            }
            if (!this.even && o.even) {
                return -1;
            }
            return Integer.parseInt(this.val) - Integer.parseInt(o.val);
        }
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2010/mathabet.dat"));
        //Scanner f = new Scanner(System.in);

        int words = f.nextInt();
        ArrayList<Word> list = new ArrayList<>();
        while (words-- > 0) {
            list.add(new Word(f.next()));
        }
        Collections.sort(list);
        for (Word word : list) {
            System.out.println(word.name);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Mathabet().run();
    }

}