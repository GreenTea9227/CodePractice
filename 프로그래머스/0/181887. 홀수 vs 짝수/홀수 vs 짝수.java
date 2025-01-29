import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int[] num_list) {
        return IntStream.range(0, 2)
						   .map(i ->
							   IntStream.range(0, num_list.length)
										.filter(j -> j % 2 == i)
                                        .map(j -> num_list[j])
										.sum()
						   ).max()
						   .orElseThrow();
        
    }
}