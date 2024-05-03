package region2024;

import java.util.*;
import java.io.*;

public class Jimothy {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/region2024/Jimothy.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(), tcase = 0; f.nextLine();
        while (tcase++ < t) {
            String[] in = f.nextLine().split(" ");
            Node root = new Node(in[0]);
            for (int i = 1; i < in.length; i++) {
                root.add(new Node(in[i]));
            }
            System.out.println("TEST CASE #" + tcase + ":");
            System.out.println("PRE-ORDER TRAVERSAL: " + pre(root).trim());
            System.out.println("IN-ORDER TRAVERSAL: " + in(root).trim());
            System.out.println("POST-ORDER TRAVERSAL: " + post(root).trim());
            System.out.println("REVERSE-ORDER TRAVERSAL: " + rev(root).trim());
        }

        f.close();
    }

    public String pre(Node cur) {
        if (cur.left == null && cur.right == null) {
            return cur.val + " ";
        }
        if (cur.left == null) {
            return cur.val + " " + pre(cur.right);
        }
        if (cur.right == null) {
            return cur.val + " " + pre(cur.left);
        }
        return cur.val + " " + pre(cur.left) + pre(cur.right);
    }

    public String in(Node cur) {
        if (cur.left == null && cur.right == null) {
            return cur.val + " ";
        }
        if (cur.left == null) {
            return cur.val + " " + in(cur.right);
        }
        if (cur.right == null) {
            return in(cur.left) + cur.val + " ";
        }
        return in(cur.left) + cur.val + " " + in(cur.right);
    }

    public String post(Node cur) {
        if (cur.left == null && cur.right == null) {
            return cur.val + " ";
        }
        if (cur.left == null) {
            return post(cur.right) + cur.val + " ";
        }
        if (cur.right == null) {
            return post(cur.left) + cur.val + " ";
        }
        return post(cur.left) + post(cur.right) + cur.val + " ";
    }

    public String rev(Node cur) {
        if (cur.left == null && cur.right == null) {
            return cur.val + " ";
        }
        if (cur.left == null) {
            return rev(cur.right) + cur.val + " ";
        }
        if (cur.right == null) {
            return cur.val + " " + rev(cur.left);
        }
        return rev(cur.right) + cur.val + " " + rev(cur.left);
    }

    public class Node {
        Node left, right;
        String val;

        public Node(String s) {
            val = s;
            left = null;
            right = null;
        }

        public void add(Node o) {
            if (o.val.compareTo(val) <= 0) {
                if (left == null) {
                    left = o;
                }
                else {
                    left.add(o);
                }
            }
            else {
                if (right == null) {
                    right = o;
                }
                else {
                    right.add(o);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        new Jimothy().run();
    }
}