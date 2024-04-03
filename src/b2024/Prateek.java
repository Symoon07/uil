package b2024;

import java.util.*;
import java.io.*;

public class Prateek {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2024/Prateek.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(nums);
            ArrayList<Integer>[] l = new ArrayList[(int) (Math.ceil(Math.log(nums.length) / Math.log(2)))];
            for (int i = 0; i < l.length; i++) {
                l[i] = new ArrayList<>();
            }
            for (int i = 0; i < nums.length; i++) {
                l[bs(nums, nums[i]) - 1].add(nums[i]);
            }
            System.out.print("List: ");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < l.length; i++) {
                System.out.print(i + 1 + "-iterations: ");
                for (int j = 0; j < l[i].size(); j++) {
                    System.out.print(l[i].get(j) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        f.close();
    }

    public int bs(int[] arr, int target) {
        int iter = 0;
        int l = 0;
        int r = arr.length - 1;
        int m =  (l + r) / 2;
        while (l <= r) {
            iter++;
            if (arr[m] == target) {
                break;
            }
            else if (arr[m] < target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
            m = (l + r) / 2;
        }
        return iter;
    }

    public static void main(String[] args) throws Exception {
        new Prateek().run();
    }
}