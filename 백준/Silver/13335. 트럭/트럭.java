
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

        int[] bridge = new int[w+1];
        int time = 0;
        while (!trucks.isEmpty()) {
            //나가고
            if (bridge[w] != 0) {
                L += bridge[w];
                bridge[w] = 0;
            }
            for (int i = w; i >=1; i--) {
                bridge[i] = bridge[i-1];
            }
            //들어오고
            if (L>=trucks.peek()) {
                Integer poll = trucks.poll();
                bridge[1] = poll;
                L -= poll;
            }
            time++;
        }
        System.out.println(time+w);

    }
}
