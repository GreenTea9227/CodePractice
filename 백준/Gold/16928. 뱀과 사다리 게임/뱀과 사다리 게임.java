

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] map = new int[101];
        boolean[] visited = new boolean[101];

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //사다리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first] = second;
        }

        //뱀
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first] = second;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1,0));
        visited[1] =true;

        int answer =0;

        /* bfs탐색 */
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            /* 종료조건 */
            if (current.getPlace()==100) {
                answer = current.depth;
                break;
            }

            for (int i = 1; i <=6; i++) {
                int next = current.getPlace() + i;

                if (next > 100 || visited[next]) {
                    continue;
                }

                if (map[next]!=0) {
                    next = map[next];
                }

                visited[next] = true;
                queue.offer(new Node(next,current.getDepth()+1));
            }
        }

        System.out.println(answer);
    }

    static class Node {
        private int place;
        private int depth;

        public Node(int place, int depth) {
            this.place = place;
            this.depth = depth;
        }

        public int getPlace() {
            return place;
        }

        public void setPlace(int place) {
            this.place = place;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }
}
