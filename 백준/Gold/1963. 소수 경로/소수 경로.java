

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static final int LEN = 10000;
    static boolean[] prime = new boolean[LEN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(LEN); i++) {

            if (!prime[i]) {
                continue;
            }

            for (int j = i*2; j < LEN; j += i) {
                prime[j] = false;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            checkChangePrime(first, second);
        }
    }

    private static void checkChangePrime(String first, String second) {

        Set<String> set = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(first, 0));

        set.add(first);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.getNum().equals(second)) {
                System.out.println(current.getDepth());
                return;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder(current.getNum());
                    sb.setCharAt(i, (char) ('0' + j));

                    String next = sb.toString();
                    if (prime[Integer.parseInt(next)] && !set.contains(next)) {
                        queue.offer(new Node(next, current.depth + 1));
                        set.add(next);
                    }
                }
            }

        }

        System.out.println(0);

    }

    static class Node {
        private String num;
        private int depth;

        public Node(String num, int depth) {
            this.num = num;
            this.depth = depth;
        }

        public String getNum() {
            return num;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }
}
