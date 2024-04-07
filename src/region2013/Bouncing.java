package region2013;

import district2013_1.DiceRoll;

import java.util.*;
import java.io.*;

public class Bouncing {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/bouncing.dat"));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        Random r = new Random();
        String[] colors = {"WHITE", "RED", "BLUE"};
        while (cases-- > 0) {

            r.setSeed(f.nextLong());
            int times = r.nextInt(10) + 1;
            //0 = White, 1 = Red, 2 = Blue
            int[] faces = {0, 1, 2}; //[0] = Bottom [1] = Front [2] = Side
            for (int i = 0; i < times; i++) {
                int dir = r.nextInt(4) + 1;
                int numTimes = r.nextInt(5) + 1;
                if ((dir == 1 ||dir == 2) && numTimes % 2 == 1) {
                    int temp = faces[0];
                    faces[0] = faces[1];
                    faces[1] = temp;
                }
                else if ((dir == 3 || dir == 4) && numTimes % 2 == 1) {
                    int temp = faces[0];
                    faces[0] = faces[2];
                    faces[2] = temp;
                }
            }

            System.out.println(colors[faces[0]]);

        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new DiceRoll().run();
    }

}