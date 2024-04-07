package region2002;

import java.util.*;
import java.io.*;

public class Name {
    
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2002/Name.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        String[] titles = "Dr. Mr. Ms. Mrs.".split(" ");
        ArrayList<String> l = new ArrayList<>();
        while (f.hasNext()) {
            l.add(f.nextLine());
        }
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < titles.length; j++) {
                if (l.get(i).startsWith(titles[j]) && l.get(i).length() < 40) {
                    System.out.println(l.get(i));
                    System.out.println(l.get(i + 1));
                    System.out.println(l.get(i + 2));
                    System.out.println();
                }
            }
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Name().run();
    }

}