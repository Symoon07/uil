package region2013;

import java.util.*;
import java.io.*;

public class GolfQ {
    static class Golfer implements Comparable<Golfer>{
        public int score;
        public String name;

        public Golfer (int score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Golfer o) {
            return this.score - o.score;
        }

        public String toString() {
            return name + " " + score;
        }
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2013/golfq.dat"));
        //Scanner f = new Scanner(System.in);

        ArrayList<Golfer> players = new ArrayList<>();
        int num = f.nextInt();
        for (int i = 0; i < num; i++) {
            String name = f.next() + " " + f.next();
            int score = f.nextInt();
            players.add(new Golfer(score, name));
        }
        ArrayList<Golfer> dupPlayers = new ArrayList<>(players);
        Collections.sort(players);

        int score = players.get(12).score;
        for (int i = 0; i < players.size(); i++) {
            if (dupPlayers.get(i).score <= score) {
                System.out.println(dupPlayers.get(i).name);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new GolfQ().run();
    }

}
