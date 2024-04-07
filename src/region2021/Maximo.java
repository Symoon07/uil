package region2021;

import java.util.*;
import java.io.*;

public class Maximo {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2021/Maximo.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String a = f.nextLine(), b = f.nextLine();
            int[] aa = Arrays.stream(a.substring(3, a.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
            int[] bb = Arrays.stream(b.substring(3, b.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for (int n : aa) {
                A.add(n);
            }
            for (int n : bb) {
                B.add(n);
            }
            Collections.sort(A);
            Collections.sort(B);
            if (A.equals(B)) {
                System.out.println("Set A is equal to Set B");
            }
            else if (A.containsAll(B)) {
                System.out.println("Set B is a subset of Set A");
            }
            else if (B.containsAll(A)) {
                System.out.println("Set A is a subset of Set B");
            }
            else {
                A.retainAll(B);
                System.out.println("Neither set is a subset of the other. Their intersection is: " + A.toString().replace(" ", "").replace("[", "{").replace("]", "}"));
            }
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Maximo().run();
    }
}