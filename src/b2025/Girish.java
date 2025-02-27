package b2025;

import java.util.*;
import java.io.*;

public class Girish {

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2025/Girish.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        ArrayList<int[]> l = new ArrayList<>();
        double mm = 0, ms = 0;
        int mode = 0, modeOcc = 0;
        while (f.hasNext()) {
            String in = f.nextLine();
            if (in.equals("----------")) {
                break;
            }
            l.add(Arrays.stream(in.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        double[] means = new double[l.size()];
        HashMap<Integer, Integer> occ = new HashMap<>();
        HashMap<Integer, Integer> app = new HashMap<>();
        for (int i = 0; i < l.size(); i++) {
            double sum = 0;
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < l.get(i).length; j++) {
                sum += l.get(i)[j];
                occ.putIfAbsent(l.get(i)[j], 0);
                occ.put(l.get(i)[j], occ.get(l.get(i)[j]) + 1);
                app.putIfAbsent(l.get(i)[j], 0);
                hs.add(l.get(i)[j]);
            }
            for (int k : hs) {
                app.put(k, app.get(k) + 1);
            }
            ms += sum;
            means[i] = sum / l.get(i).length;
        }
        Arrays.sort(means);
        mm = means.length % 2 == 0 ? (means[means.length / 2] + means[means.length / 2 - 1]) / 2 : means[means.length / 2];
        ms /= l.size();
        for (int k : occ.keySet()) {
            if (app.get(k) != l.size()) {
                if (occ.get(k) > modeOcc) {
                    modeOcc = occ.get(k);
                    mode = k;
                }
            }
        }
        System.out.printf("Median Mean: %.2f%n", mm);
        System.out.printf("Mean Sum: %.2f%n", ms);
        System.out.println("Mode Kinda: " + mode);

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Girish().run();
    }

}