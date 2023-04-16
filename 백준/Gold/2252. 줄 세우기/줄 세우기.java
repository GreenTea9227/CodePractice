

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] student = new int[N + 1];
        List<Integer>[] list = new List[N + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            student[b]++;
            list[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, student.length).filter(i -> student[i] == 0).forEach(queue::offer);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            List<Integer> integers = list[cur];

            integers.stream().forEach( i -> {
                student[i]--;
                if (student[i] == 0)
                    queue.offer(i);});

            sb.append(cur).append(" ");

        }

        System.out.println(sb);

    }
}
