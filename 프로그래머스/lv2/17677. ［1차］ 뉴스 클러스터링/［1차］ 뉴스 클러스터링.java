
import java.util.*;

class Solution {

        public int solution(String str1, String str2) {
            int answer = 0;
            str1 = str1.toUpperCase();
            str2 = str2.toUpperCase();
            
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            List<String> inter = new ArrayList<>();
            List<String> union = new ArrayList<>();

            for (int i = 0; i < str1.length() - 1; i++) {
                char a1 = str1.charAt(i);
                char a2 = str1.charAt(i + 1);
                if (Character.isAlphabetic(a1) && Character.isAlphabetic(a2)) {
                    list1.add(a1+""+a2);
                }
            }

           

            for (int i = 0; i < str2.length() - 1; i++) {
                char a1 = str2.charAt(i);
                char a2 = str2.charAt(i + 1);
                
                if (!Character.isAlphabetic(a1) || !Character.isAlphabetic(a2)) {
                    continue;
                }
                list2.add(a1+""+a2); 
            }
            
            int max =list1.size() + list2.size();
            int min =0;
            for (String cur1 : list1 ) {
                if (list2.remove(cur1)) {
                   inter.add(cur1);
                }
                union.add(cur1);
            }
            for(String s : list2){
                 union.add(s);
             }
            
            double ans =   union.size() == 0  ? 1 : (double) inter.size() /union.size();
            return (int)(ans * 65536);
        }
    }