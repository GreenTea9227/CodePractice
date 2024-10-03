
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short t = sc.nextShort();

		int[] arr = new int[1001];
		List<Integer> list = new ArrayList<>();
		int index = 1;
		int total = 0;
		while ((total = (index * (index + 1) / 2))  <= 1000) {
			list.add(total);
			index++;
		}
		for (int j1 = 0; j1 < list.size(); j1++) {
			for (int j2 = 0; j2 < list.size(); j2++) {
				for (int j3 = 0; j3 < list.size(); j3++) {
					int num = list.get(j1) + list.get(j2) + list.get(j3);
					if (num <= 1000)
						arr[num]++;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			short cur = sc.nextShort();
			 if (arr[cur] == 0)
				 System.out.println("0");
			 else
				 System.out.println("1");
		}

	}
}
