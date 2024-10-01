import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
        }
        int target = Integer.parseInt(br.readLine());
        list.sort(Comparator.naturalOrder());

        int start = 0;
        int end = list.size() - 1;
        int count = 0;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum == target) {
                count++;
                start++;
                end--;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(count);



    }
}
