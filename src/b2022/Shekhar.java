package b2022;

import java.util.*;
import java.io.*;

public class Shekhar {
    public void run() throws Exception {
        Scanner f = new Scanner(new File("Data/b2022/Shekhar.dat"));
        //Scanner f = new Scanner(System.in);

        int t = f.nextInt(); f.nextLine();
        while (t --> 0) {
            String line = f.nextLine();
            Stack<Character> s = new Stack<>();
            boolean valid = true;
            for (int i = 0; i < line.length(); i++) {
                char cur = line.charAt(i);
                if (cur == '(' || cur == '[' || cur == '{') {
                    s.add(line.charAt(i));
                }
                else if (cur == ')' || cur == ']' || cur == '}') {
                    if (s.isEmpty()) {
                        valid = false;
                        break;
                    }
                    else {
                        char top = s.pop();
                        if (!((top == '(' && cur == ')') || (top == '[' && cur == ']') || (top == '{' && cur == '}'))) {
                            valid = false;
                            break;
                        }
                    }
                }
            }
            System.out.println(s.isEmpty() && valid ? line + " is nested correctly" : line + " is nested incorrectly");
        }

        f.close();
    }
    
    public static void main(String[] args) throws Exception {
        new Shekhar().run();
    }
}