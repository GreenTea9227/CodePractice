
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(arr, 0);

        System.out.println(answer);

    }

    public static void dfs(int[][] arr, int count) {

        if (count == 5) {
            findMax(arr);
            return;
        }

        for (int i = 0; i <= 3; i++) {
            int[][] copyArray = copyArray(arr);
            int[][] ints = pushDown(copyArray);
            dfs(ints, count + 1);
            rotateAngle(arr);
        }
    }

    public static int[][] copyArray(int[][] arr) {
        int len = arr.length;
        int[][] copyArray = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                copyArray[i][j] = arr[i][j];
            }
        }
        return copyArray;
    }

    public static void rotateAngle(int[][] arr) {

        int len = arr.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[len - i - 1][j];
                arr[len - i - 1][j] = temp;
            }

        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

    }

    public static int[][] pushDown(int[][] arr) {
        Stack<Integer> stack = new Stack<>();

        int len = arr.length;
        int[][] newArray = new int[len][len];
        for (int i = 0; i < len; i++) {
            boolean isNew = true;
            for (int j = len - 1; j >= 0; j--) {
                int current = arr[j][i];

                if (current == 0)
                    continue;

                if (stack.empty() || stack.peek() != current) {
                    stack.push(current);
                    isNew = true;
                    continue;
                }
                //같은 값이지만 한번도 사용한 적 없는 값
                if (isNew) {
                    Integer pop = stack.pop();
                    stack.push(current + pop);
                    isNew = false; //사용함 표시
                    continue;
                }

                isNew = true;
                stack.push(current);
            }

            int count = len - stack.size();
            while (!stack.empty()) {
                newArray[count++][i] = stack.pop();
            }
        }
        return newArray;
    }

    public static void findMax(int[][] arr) {

        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                answer = Math.max(ints[j], answer);
            }
        }

    }
}