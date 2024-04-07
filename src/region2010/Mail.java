package region2010;

import java.util.*;
import java.io.*;

public class Mail {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/regional2010/Mail.dat".toLowerCase()));
        //Scanner f = new Scanner(System.in);

        int cases = f.nextInt();
        while (cases-- > 0) {
            int n = f.nextInt();
            HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                int nM = f.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                while (nM-- > 0) {
                    list.add(f.nextInt());
                }
                adjList.put(i, list);
            }
            int max = 0;
            for (int key : adjList.keySet()) {
                HashSet<Integer> visited = new HashSet<>();
                Queue<Integer> q = new LinkedList<>();
                q.add(key);
                int num = 0;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    if (visited.contains(cur)) {
                        continue;
                    }
                    visited.add(cur);
                    num++;
                    q.addAll(adjList.get(cur));
                    max = Math.max(max, num);
                }
            }
            System.out.println(max);
        }

        f.close();
    }

    public static void main(String[] args) throws Exception {
        new Mail().run();
    }

}