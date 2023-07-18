import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
       int answer=0;
     int count = 0;
     HashMap<String, Integer> map;
      Queue<String> queue;
    public int solution(String[] want, int[] number, String[] discount) {
        queue = new LinkedList<>();
        map = IntStream.range(0, want.length)
                .boxed()
                .collect(Collectors.toMap(i -> want[i], i -> number[i], (a, b) -> b, HashMap::new));

        for (int i=0;i<10;i++) {
            addQueue(want, discount[i]);

        }

        for (int i = 10; i < discount.length; i++) {
            String poll = queue.poll();
            if (map.containsKey(poll)) {
                pollQueue(poll);
            }
            addQueue(want, discount[i]);
        }

        return answer;
    }

    private  void pollQueue(String poll) {
        Integer num = map.get(poll);
        if (num == 0)
            count--;
        map.put(poll,map.get(poll)+1);
    }

    private  void addQueue(String[] want, String discount) {
        String key = discount;
        if (map.containsKey(key)) {
            logic(key, want.length);
        }
        queue.offer(key);
    }

    public  void logic(String key, int len) {
        map.put(key,map.get(key)-1);
        if (map.get(key)==0)
            count++;

        if (count == len)
            answer++;
    }

}