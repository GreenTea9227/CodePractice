
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f1 = sc.nextInt();
        int f2 = sc.nextInt();

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < f1; i++) {
            String listen = sc.nextLine();
            set.add(listen);
        }
        for (int i = 0; i < f2; i++) {
            String see = sc.nextLine();
            if (!set.add(see)) {
                list.add(see);
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }

    }
}
