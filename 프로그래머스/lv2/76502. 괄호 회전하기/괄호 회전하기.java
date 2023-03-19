import java.util.Stack;
class Solution {
        public int solution(String s) {
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                if (check(s)) {
                    answer++;
                }
                s = s.substring(1) + s.charAt(0);
            }
            return answer;
        }

        private boolean check(String s) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                    continue;
                }
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                    continue;
                }
                if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                }
            }
            
            return stack.isEmpty();
        }
    }