package p4_1_2024;

import java.util.*;
import java.io.*;

public class Webs {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice4_1/Webs.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int webs = 0;
            for (int i = 0; i < 6; i++) {
                String[] in = f.nextLine().split(", ");
                webs += con(in[0]) + Integer.parseInt(in[1]);
            }
            int[] val = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            val[0] = Math.max((int) Math.ceil(webs / 5.) - val[0], 0);
            val[1] = Math.max((int) Math.ceil(webs / 12.) - val[1], 0);
            val[2] = Math.max((int) Math.ceil(webs / 8.) - val[2], 0);
            val[3] = Math.max((int) Math.ceil(webs / 3.) - val[3], 0);
            val[4] = Math.max((int) Math.ceil(webs / 3.) - val[4], 0);
            System.out.printf("%s:%s:%s:%s:%s\n", val[0], val[1], val[2], val[3], val[4]);
        }

        f.close();
    }

    public int con(String s) {
        return switch (s) {
            case "Doc Ock" -> 11;
            case "Lizard", "Scorpion" -> 8;
            case "Venom", "Carnage", "Hobgoblin" -> 7;
            case "Green Goblin", "Rhino" -> 5;
            case "Mysterio", "Chameleon" -> 1;
            case "Electro", "Kingpin" -> 3;
            case "Sandman" -> 12;
            default -> 2;
        };
    }

    public static void main(String[] args) throws Exception {
        new Webs().run();
    }
}