
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.IntStream;



    class Solution {
        public String[] solution(int[][] line) {

            HashSet<Point> set = new HashSet<>();

            long minx = Long.MAX_VALUE;
            long miny = Long.MAX_VALUE;
            long maxx = Long.MIN_VALUE;
            long maxy = Long.MIN_VALUE;

            for (int i = 0; i < line.length; i++) {
                for (int j = i + 1; j < line.length; j++) {
                    long a = line[i][0];
                    long b = line[i][1];
                    long e = line[i][2];
                    long c = line[j][0];
                    long d = line[j][1];
                    long f = line[j][2];

                    long under = a * d - b * c;
                    if (under == 0)
                        continue;

                    long upx = b * f - e * d;
                    long upy = e * c - a * f;

                    if (upx % under != 0 || upy % under != 0)
                        continue;

                    long x =  upx / under;
                    long y =  upy / under;


                    minx = Math.min(minx, x);
                    miny = Math.min(miny, y);
                    maxx = Math.max(maxx, x);
                    maxy = Math.max(maxy, y);

                    set.add(new Point(x, y));

                }
            }


            long height = maxy - miny + 1;
            long width = maxx - minx + 1;

            char[][] chars = new char[(int)height][(int)width];

            for (char[] aChar : chars) {
                Arrays.fill(aChar, '.');
            }

            for (Point point : set) {
                int nx = (int)(point.x - minx);
                int ny = (int)(maxy - point.y);

                chars[ny][nx] = '*';
            }

            String[] answer = Arrays.stream(chars)
                    .map(String::valueOf)
                    .toArray(String[]::new);


            return answer;
        }
    }

     class Point {
         long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    
     }