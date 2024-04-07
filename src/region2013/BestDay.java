package region2013;

import java.util.*;
import java.io.*;

public class BestDay {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/bestday.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {

            int[] sales = new int[7];
            int day = -1;
            int max = 0;
            for (int i = 0; i < sales.length; i++) {
                sales[i] = f.nextInt();
                if (sales[i] > max) {
                    max = sales[i];
                    day = i;
                }
            }

            String[] days = "SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY SATURDAY".split(" ");
            System.out.println(days[day]);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new BestDay().run();
    }

}