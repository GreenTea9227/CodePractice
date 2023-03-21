 import java.util.*;


class Solution {
    String[] logic = {"*", "+", "-"};
     boolean[] visited = new boolean[3];

     List<String> operation = new ArrayList<>();
     List<Long> numbers = new ArrayList<>();
     long ans = 0;
    
    public long solution(String expression) {

        String[] split = expression.split("[-*+]");
        String num ="";
        for (int i = 0; i < expression.length(); i++) {
            char charAt = expression.charAt(i);
            if (charAt == '*' || charAt == '+' ||  charAt == '-') {
                operation.add(charAt+"");
                numbers.add(Long.parseLong(num));
                num="";
            } else {
                num+=charAt;
            }
        }
        numbers.add(Long.parseLong(num));

        permutation(logic, 0, new ArrayList<>());

        return ans;
    }
    

     public void permutation(String[] exp, int depth, List<String> list) {

        if (depth == 3) {
            ArrayList<String> strings = new ArrayList<>(list);
            dfs(strings);
            return;
        }

        for (int i = 0; i < exp.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(exp[i]);
                permutation(exp, depth + 1, list);
                list.remove(exp[i]);
                visited[i] = false;
            }
        }
    }

     public void dfs(ArrayList<String> strings) {

        List<Long> numberList = new ArrayList<>(numbers);
        List<String> operList = new ArrayList<>(operation);

        for (int i = 0; i < strings.size(); i++) {
            String index = strings.get(i);


            for (int j = 0; j < operList.size(); j++) {

                if (operList.get(j).equals(index)) {
                    long first = numberList.get(j);
                    long second = numberList.get(j+1);
                    long calc = calc(first, second, index);

                    numberList.remove(j+1);
                    numberList.remove(j);
                    operList.remove(j);

                    numberList.add(j,calc);

                    j--;
                }
            }
        }

        ans = Math.max(Math.abs(numberList.get(0)), ans);
    }



     public long calc(long ca, long cb, String str) {
        long result = 0;

        switch (str) {
            case "*":
                result = ca * cb;
                break;
            case "-":
                result = ca - cb;
                break;
            case "+":
                result = ca + cb;
                break;
        }
        return result;
    }
}