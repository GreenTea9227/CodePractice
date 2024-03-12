import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int[][] arr;
	private static int N, M, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			switch (st.nextToken()) {
				case "1" -> upDown();
				case "2" -> leftRight();
				case "3" -> clock();
				case "4" -> reverseClock();
				case "5" -> divideClock();
				case "6" -> divideReverseClock();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void leftRight() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				change(i, j, i, M - 1 - j);
			}
		}
	}

	private static void upDown() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				change(i,j,N-1-i,j);
			}
		}
	}

	private static void clock() {
		upDown();
		diagonal();
	}

	private static void reverseClock() {
		leftRight();
		diagonal();
	}

	private static void diagonal() {
		int[][] newArr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				newArr[i][j] = arr[j][i];
			}
		}
		arr = newArr;
		int tmp = N;
		N = M;
		M = tmp;
	}

	private static void divideClock() {
		int[][] newArr = new int[N][M];
		for(int i=0; i<N/2; i++){
			for(int j=0; j<M/2; j++){
				newArr[i][M/2+j] = arr[i][j];
			}
		}

		for(int i=0; i<N/2; i++){
			for(int j=M/2; j<M; j++){
				newArr[N/2+i][j] = arr[i][j];
			}
		}

		for(int i=N/2; i<N; i++){
			for(int j=M/2; j<M; j++){
				newArr[i][j-M/2] = arr[i][j];
			}
		}

		for(int i=N/2; i<N; i++){
			for(int j=0; j<M/2; j++){
				newArr[i-N/2][j] = arr[i][j];
			}
		}
		arr = newArr;
	}

	private static void divideReverseClock() {
		int[][] newArr = new int[N][M];
		for(int i=0; i<N/2; i++){
			for(int j=0; j<M/2; j++){
				newArr[i + N/2][j] = arr[i][j];
			}
		}

		for(int i=0; i<N/2; i++){
			for(int j=M/2; j<M; j++){
				newArr[i][j - M/2] = arr[i][j];
			}
		}

		for(int i=N/2; i<N; i++){
			for(int j=M/2; j<M; j++){
				newArr[i-N/2][j] = arr[i][j];
			}
		}

		for(int i=N/2; i<N; i++){
			for(int j=0; j<M/2; j++){
				newArr[i][j+M/2] = arr[i][j];
			}
		}
		arr = newArr;
	}



	private static void change(int i1, int j1, int i2, int j2) {
		int tmp = arr[i1][j1];
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = tmp;
	}

}
