import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
         int answer=0;
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = IntStream.range(0, want.length)
                .boxed()
                .collect(Collectors.toMap(i -> want[i], i -> number[i], (a, b) -> b, HashMap::new));

        for (int i=0;i<10;i++) {
            String key = discount[i];
            if (map.containsKey(key)) {
                map.put(key,map.get(key)-1);
                if (map.get(key)==0)
                    count++;

                if (count == want.length)
                    answer++;
            }

            queue.offer(key);

        }

        for (int i = 10; i < discount.length; i++) {
            String poll = queue.poll();
            if (map.containsKey(poll)) {
                Integer num = map.get(poll);
                if (num == 0)
                    count--;
                map.put(poll,map.get(poll)+1);
            }

            String key = discount[i];
            if (map.containsKey(key)) {
                map.put(key,map.get(key)-1);
                if (map.get(key)==0)
                    count++;

                if (count == want.length)
                    answer++;
            }

            queue.offer(key);
        }

        return answer;
    }
}