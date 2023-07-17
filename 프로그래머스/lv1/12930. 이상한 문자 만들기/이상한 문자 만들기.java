import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
    int num = 0;
      for (int i=0;i<s.length();i++) {
          
          char c = s.charAt(i);
          if (c == ' ') {
            num = 0;
              sb.append(" ");
            continue;
          }
          
          if (num%2==0) {
              sb.append(Character.toUpperCase(c));
          } else {
              sb.append(Character.toLowerCase(c));
          }
          
          num++;
      }
        return sb.toString();
        
    }
}