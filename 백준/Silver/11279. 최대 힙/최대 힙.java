

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num =Integer.parseInt(br.readLine());

            if (num== 0) {
                if (queue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(queue.poll());
            } else {
                queue.offer(num);
            }
        }
        br.close();
    }
}
