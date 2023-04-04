

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] ax = new int[]{0, 0, 1, -1};
    static int[] ay = new int[]{1, -1, 0, 0};

    static int R,C;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

         R = Integer.parseInt(s[0]);
         C = Integer.parseInt(s[1]);

        int[][] map = new int[R][C];
        boolean[][] visited = new boolean[R][C];

        Queue<Node> hedgehog = new LinkedList<>();
        Queue<Node> water = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String[] strings = br.readLine().split("");

            for (int j = 0; j < C; j++) {
                String str = strings[j];
                int cur = 0;
                if (str.equals("*")) {
                    cur = -1;
                    water.offer(new Node(j, i));
                } else if (str.equals("D")) {
                    cur = 2;
                } else if (str.equals("X")) {
                    cur = -2;
                } else if (str.equals("S")) {
                    cur = 1;
                    hedgehog.offer(new Node(j, i, 0));
                    visited[i][j] =true;
                }
                map[i][j] = cur;
            }
        }

        while (!hedgehog.isEmpty()) {
            //물 이동
            int n1 = water.size();

            for (int j=0;j<n1;j++) {
                Node waterPoll = water.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = waterPoll.x + ax[i];
                    int ny = waterPoll.y + ay[i];
                    if (!checkRange(nx, ny))
                        continue;

                    if (map[ny][nx] != -2 && map[ny][nx] != 2 && map[ny][nx] != -1) {
                        map[ny][nx] = -1;
                        water.offer(new Node(nx, ny));
                    }
                }
            }

            //고슴도치 이동
            int n2 = hedgehog.size();
            for (int j=0;j<n2;j++) {
                Node poll = hedgehog.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + ax[i];
                    int ny = poll.y + ay[i];

                    if (!checkRange(nx, ny))
                        continue;

                    if (map[ny][nx]==2) {
                        System.out.println(poll.count+1);
                        return;
                    }

                    if (map[ny][nx] != -1 && map[ny][nx] !=-2 && !visited[ny][nx]) {
                        hedgehog.offer(new Node(nx,ny, poll.count+1));
                        visited[ny][nx]=true;
                    }
                }
            }
        }

        System.out.println( "KAKTUS");

    }

    private static boolean checkRange(int nx, int ny) {
        return ny >= 0 && ny < R && nx >= 0 && nx < C;
    }

    static class Node {
        private int x;
        private int y;
        private int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
