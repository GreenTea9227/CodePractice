import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        int changeCount = 0;
        int removeCount = 0;

        while (s.length() != 1) {

            int len = s.length();
            long count = Arrays.stream(s.split("")).filter(i -> i.equals("0")).count();

            removeCount += count;
            long strLen = len - count;

            s = Long.toBinaryString(strLen);

            changeCount++;
        }

        return new int[]{changeCount,removeCount};

    }

}