
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.offer(0);
        }

        int time = 0;
        while (!bridge.isEmpty()) {
            time++;
            L += bridge.poll();

            if (trucks.isEmpty())
                continue;

            if (L >= trucks.peek()) {
                int truck = trucks.poll();
                bridge.offer(truck);
                L -= truck;
            } else {
                bridge.offer(0);
            }

        }
        System.out.println(time);

    }
}
