

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();


        int first = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < first; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                map.replace(num,map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }
        int second = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i <second; i++) {
            int num = Integer.parseInt(st.nextToken());

            Integer obj = map.get(num);
            if (obj==null) {
                sb.append(0);
            } else {
                sb.append(obj);
            }
            sb.append(" ");
        }
        System.out.println(sb);



    }
}
