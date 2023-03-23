

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long start = 0;
        long end = trees[trees.length-1] ;



        while (start <= end ) {
            long mid = (start+end)/2;

            long num=0;

            for (int tree : trees) {
                if (tree > mid)
                    num += tree - mid;
            }

            if (num >= M) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(end);

    }
}
