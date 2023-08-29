import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
     private  String dfs(String p) {
        if (p.isBlank())
            return p;

        int f1 = 0;
        int f2 = 0;
        int index = 0;
        while (index < p.length()) {
            if (p.charAt(index) == '(')
                f1++;
            else
                f2++;
            if (f1 == f2)
                break;
            index++;
        }
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

        return check(u) ? u + dfs(v) : "(" + dfs(v) + ")" + change(u);
    }


    private  String change(String p) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < p.length() - 1; i++) 
            sb.append(p.charAt(i) == '(' ? ')' : '(');
        return sb.toString();
    }

    private  boolean check(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else 
                stack.push('(');  
        }
        return stack.isEmpty();
    }
}