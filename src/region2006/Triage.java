package region2006;

import java.util.*;
import java.io.*;

public class Triage {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2006/Triage.in".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt();
        while (t --> 0) {
            int n = f.nextInt();
            PriorityQueue<P> pq = new PriorityQueue<>();
            ArrayList<P> l = new ArrayList<>();
        }

        f.close();
    }

    public class P implements Comparable<P> {
        int arrival;
        int priority;
        int time;

        public P(int a, int p, int t) {
            arrival = a;
            priority = p;
            time = t;
        }

        @Override
        public int compareTo(P o) {
            if (priority == o.priority) {
                return o.time - time;
            }
            return priority - o.priority;
        }
    }

    public static void main(String[] args) throws Exception {
        new Triage().run();
    }

}