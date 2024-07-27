import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        return my_string.chars()
                .mapToObj(c -> (char) c)
                .map(c -> Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}