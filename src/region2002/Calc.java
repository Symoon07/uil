package region2002;

import java.util.*;
import java.io.*;

public class Calc {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2002/Calc.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        String[] b = "0.=/321*654-987+".split("");
        int k = 0;
        ArrayList<Button> l = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                l.add(new Button(b[k++], 10 + j * 25, 30 + j * 25, 15 + i * 25, 30 + i * 25));
            }
        }
        while (f.hasNext()) {
            int x = f.nextInt();
            int y = f.nextInt();
            boolean hit = false;
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).check(x, y)) {
                    System.out.println(l.get(i).v);
                    hit = true;
                    break;
                }
            }
            if (!hit) {
                System.out.println("Panel");
            }
        }

        f.close();
    }

    public class Button {
        String v;
        int x1;
        int x2;
        int y1;
        int y2;

        public Button(String v, int x1, int x2, int y1, int y2) {
            this.v = v;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public boolean check(int x, int y) {
            return x >= x1 && x <= x2 && y >= y1 && y <= y2;
        }
    }

    public static void main(String[] args) throws Exception {
        new Calc().run();
    }

}