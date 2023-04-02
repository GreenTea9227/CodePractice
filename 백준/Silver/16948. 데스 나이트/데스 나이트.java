

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] arrx = new int[]{-2, -2, 0, 0, 2, 2};
    static int[] arry = new int[]{-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        boolean[][] visited = new boolean[N + 1][N + 1];

        int fx = sc.nextInt();
        int fy = sc.nextInt();
        Point start = new Point(fx, fy, 0);

        int sx = sc.nextInt();
        int sy = sc.nextInt();
        Point end = new Point(sx, sy, 0);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[fy][fx] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.equals(end)) {
                System.out.println(current.getCount());
                return;
            }


            for (int i = 0; i < arrx.length; i++) {
                int nx = arrx[i] + current.getX();
                int ny = arry[i] + current.getY();

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[ny][nx]) {
                    continue;
                }

                Point point = new Point(nx, ny, current.count + 1);
                queue.offer(point);
                visited[ny][nx] = true;

            }
        }

        System.out.println(-1);


    }

    static class Point {
        private int x;
        private int y;
        private int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return getX() == point.getX() && getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}
