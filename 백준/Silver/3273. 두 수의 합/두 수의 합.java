import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start=0;
        int end=arr.length-1;
        int count=0;
        while (start < end) {
            int current = arr[start]+arr[end];
            if (current==target) {
                count++;
                start++;
                end--;
            } else if (current < target) {
                start++;
            } else {
                end--;
            }

        }
        System.out.println(count);

    }
}
