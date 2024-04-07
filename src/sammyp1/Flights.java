package sammyp1;

import java.util.*;
import java.io.*;

public class Flights {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/sammyp1/Flights.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0;
        while (tcase++ < t) {
            int n = f.nextInt();
            TreeSet<F> ts = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                ts.add(new F(f.next(), f.next(), f.nextDouble(), f.nextInt(), f.nextDouble()));
            }
            System.out.println("Top Flights Set " + tcase + ":");
            for (int i = 1; i <= n && i <= 3; i++) {
                System.out.println(i + ": " + ts.removeFirst());
            }
        }

        f.close();
    }

    public class F implements Comparable<F> {
        String name;
        int time;
        double rating;
        int window;
        double price;

        public F(String n, String t, double r, int w, double p) {
            name = n;
            String[] s = t.split(":");
            time = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            rating = r;
            window = w;
            price = p;
        }

        @Override
        public int compareTo(F o) {
            if (con(time) == con(o.time)) {
                if (window == o.window) {
                    if (rating == o.rating) {
                        if (price == o.price) {
                            return name.compareTo(o.name);
                        }
                        return Double.compare(price, o.price);
                    }
                    return Double.compare(o.rating, rating);
                }
                return o.window - window;
            }
            return con(o.time) - con(time);
        }

        public String toString() {
            return name;
        }
    }

    public int con(int t) {
        if (t >= 720 && t <= 900) {
            return 2;
        }
        if (t >= 600 && t <= 1020) {
            return  1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Flights().run();
    }
}