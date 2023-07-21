import java.util.*;

class Solution {
    public String[] solution(String[] files) {
     List<String> list = new ArrayList<>(Arrays.asList(files));
        list.sort((a, b) -> {
            String head1 = getHead(a);
            String head2 = getHead(b);

            if (head1.equals(head2))
                return getNumber(a.toLowerCase(), head1) - getNumber(b.toLowerCase(), head2);

            return head1.compareTo(head2);
        });

        return list.toArray(new String[0]);


    }

    public static String getHead(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                break;
            }
            sb.append(ch);
        }
        return sb.toString().toLowerCase();
    }

    public static int getNumber(String str, String head) {
        String replace = str.replace(head, "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < replace.length() && sb.length() < 5; i++) {
            char ch = replace.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            sb.append(ch);
        }
        return Integer.parseInt(sb.toString());
    }
}
