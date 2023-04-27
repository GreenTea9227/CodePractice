

import java.util.Arrays;
import java.util.stream.IntStream;



 class Solution {

        int[][] answer;
        int x = 0;
        int y = 0;
        int num = 2;
        int floor;

        public int[] solution(int n) {
            answer = new int[n][n];
            answer[0][0]=1;
            floor = n;
            int sum = IntStream.rangeClosed(1, n).sum();

            while (num <= sum) {
                moveDown();
                moveRight();
                moveUp();
            }

            return Arrays.stream(answer)
                    .flatMapToInt(Arrays::stream)
                    .filter(i -> i != 0)
                    .toArray();
        }

        public void moveDown() {

            int next = y + 1;
            if (next >= floor || answer[next][x] != 0) {
                return;
            }
            y = next;
            answer[y][x] = num++;

            moveDown();
        }

        public void moveRight() {

            int next = x + 1;
            if (next >= floor || answer[y][next] != 0) {
                return;
            }
            x = next;
            answer[y][x] = num++;

            moveRight();
        }

        public void moveUp() {

            int nextX = x - 1;
            int nextY = y - 1;
            if (nextX < 0 || nextX >= floor || nextY < 0 || nextY >= floor || answer[nextY][nextX] != 0) {
                return;
            }
            x = nextX;
            y = nextY;
            
            answer[nextY][nextX] = num++;
            moveUp();

        }

    }

