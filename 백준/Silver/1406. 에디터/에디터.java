
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = br.readLine();
        int T = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i=0;i<start.length();i++) {
            left.push(start.charAt(i));
        }

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            switch (s.charAt(0)) {
                case 'P' -> {
                   left.push(s.charAt(s.length()-1));
                }
                case 'L' -> {
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                }
                case 'D' -> {
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                }
                case 'B' -> {
                    if (!left.isEmpty())
                        left.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
