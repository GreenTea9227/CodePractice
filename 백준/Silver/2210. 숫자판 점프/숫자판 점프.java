
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<String> answer = new HashSet<>();
	static int[][] arr;
	static int[] dx = new int[]{0,0,1,-1};
	static int[] dy = new int[]{1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				brute(i,j,0,"");
			}
		}
		System.out.println(answer.size());

	}

	public static void brute(int x, int y,int depth,String ans) {
		if (depth == 6) {
			answer.add(ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx >=0 && nx < 5 && ny >=0 && ny <5) {
				brute(nx,ny,depth+1,ans+arr[nx][ny]);
			}
		}
	}
}
