
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Queue<String> queue = new PriorityQueue<>(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            if (!queue.contains(str)) {
                queue.offer(str);
            }
        }
        while (!queue.isEmpty()) {
            bw.write(queue.poll()+"\n");
            bw.flush();
        }
        bw.close();
    }
}
