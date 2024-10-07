
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static boolean[][] updown;
	static boolean[][] leftright;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		String command = sc.nextLine();
		updown = new boolean[N][N];
		leftright = new boolean[N][N];
		int cury = N-1;
		int curx = 0;
		for (int i = 0; i <command.length() ; i++) {
			char c = command.charAt(i);
			if (c == 'R') {
				if (curx + 1 >= N)
					continue;
				leftright[cury][curx] = leftright[cury][curx+1] = true;
				curx++;
			} else if (c == 'L') {
				if (curx - 1 < 0)
					continue;
				leftright[cury][curx] = leftright[cury][curx-1] = true;
				curx--;
			} else if (c == 'D') {
				if (cury - 1 < 0)
					continue;
				updown[cury][curx] = updown[cury-1][curx] = true;
				cury--;
			} else if (c == 'U') {
				if (cury + 1 >= N)
					continue;
				updown[cury][curx] = updown[cury+1][curx] = true;
				cury++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = N-1; i >=0; i--) {
			for (int j = 0; j < N; j++) {
				if (updown[i][j] && leftright[i][j]) {
					sb.append('+');
				} else if (updown[i][j] && !leftright[i][j]) {
					sb.append('|');
				} else if (!updown[i][j] && leftright[i][j]) {
					sb.append('-');
				} else {
					sb.append('.');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

}
