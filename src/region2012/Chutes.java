package region2012;

import java.util.*;
import java.io.*;

public class Chutes {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2012/Chutes.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int n = f.nextInt();
        while (n-- > 0) {
            int p = f.nextInt();
            int[] players = new int[p];
            Arrays.fill(players, 1);
            long seed = f.nextLong();
            Random ran = new Random(seed);
            int c = f.nextInt();
            int d = f.nextInt();
            HashMap<Integer, Integer> chutes = new HashMap<>();
            HashMap<Integer, Integer> ladders = new HashMap<>();
            while (c-- > 0) {
                chutes.put(f.nextInt(), f.nextInt());
            }
            while (d-- > 0) {
                ladders.put(f.nextInt(), f.nextInt());
            }
            int Y = 0;
            game : while (true) {
                for (int i = 0; i < players.length; i++) {
                    Y++;
                    int dice = ran.nextInt(6)+1;
                    players[i] += dice;
                    if (players[i] >= 64) {
                        System.out.println("Player " + (char) (i + 65) + " wins after " +  Y + " rolls!");
                        break game;
                    }
                    while (chutes.containsKey(players[i]) || ladders.containsKey(players[i])) {
                        if (chutes.containsKey(players[i])) {
                            players[i] = chutes.get(players[i]);
                        }
                        else if (ladders.containsKey(players[i])) {
                            players[i] = ladders.get(players[i]);
                        }
                    }
                }
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Chutes().run();
    }

}