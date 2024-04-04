package p11_16_2023;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Isabel {
    String[] weeks = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/practice11_16/Isabel.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM");
        ArrayList<P> l = new ArrayList<>();
        while (f.hasNext()) {
            String name = f.next();
            int year = f.nextInt();
            int month = f.nextInt()-1;
            int day = f.nextInt();
            GregorianCalendar gc = new GregorianCalendar(year, month, day);
            String mon = sdf.format(gc.getTime());
            l.add(new P(name, year, mon, day, gc.get(Calendar.DAY_OF_WEEK)));
        }
        Collections.sort(l);
        for (P p : l) {
            System.out.println(p);
        }

        f.close();
    }

    public class P implements Comparable<P> {
        String name;
        int year;
        String month;
        int day;
        int dayWeek;

        public P (String n, int y, String m, int d, int dw) {
            name = n;
            year = y;
            month = m;
            day = d;
            dayWeek = dw;
        }

        @Override
        public int compareTo(P o) {
            if (dayWeek == o.dayWeek) {
                return name.compareTo(o.name);
            }
            return dayWeek - o.dayWeek;
        }

        public String toString() {
            return String.format("%-12s: %s, %s %d, %d", name, weeks[dayWeek-1], month, day, year);
        }
    }

    public static void main(String[] args) throws Exception {
        new Isabel().run();
    }

}