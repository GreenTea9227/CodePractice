import java.util.stream.*;
import java.util.*;

class Solution {
        public int solution(int[] topping) {
            int answer = 0;
            Map<Integer, Long> map = Arrays.stream(topping).boxed()
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()));


            int first = map.size();
            Set<Integer> second = new HashSet<>();

            for (int i = 0; i < topping.length; i++) {

                map.compute(topping[i],(key,value) -> value-1);
                second.add(topping[i]);
                if (map.get(topping[i])==0)
                    first--;
                if (first == second.size()) {
                    answer++;
                }
            }
            return answer;
        }
    }
