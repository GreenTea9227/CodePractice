import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return s.chars().boxed().sorted((a,b) -> b-a).map(i -> Character.toString(i))
                .collect(Collectors.joining());
    }
}