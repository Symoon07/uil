package a2025;

import java.util.*;
import java.io.*;

public class Jason {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/a2025/Jason.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] rain = new int[12];
        int max = 0;
        for (int i = 0; i < 12; i++) {
            double sum = 0;
            for (int j = 0; j < days[i]; j++) {
                sum += f.nextDouble();
            }
            rain[i] = (int) Math.round(sum / days[i]);
            max = Math.max(max, rain[i]);
        }
        for (int i = max; i >= 0; i--) {
            for (int j = 0; j < 12; j++) {
                System.out.print(rain[j] > i ? "***** " : "      ");
            }
            System.out.println();
        }
        System.out.println(" Jan   Feb   Mar   Apr   May   Jun   Jul   Aug   Sep   Oct   Nov   Dec");

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Jason().run();
    }

}