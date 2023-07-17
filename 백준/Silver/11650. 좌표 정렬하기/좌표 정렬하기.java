
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        Queue<int[]> queue = new PriorityQueue<>((a,b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        for (int i = 0; i < T; i++) {
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            queue.offer(new int[]{f1,f2});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            System.out.println(poll[0]+" "+poll[1]);
        }
    }
}
