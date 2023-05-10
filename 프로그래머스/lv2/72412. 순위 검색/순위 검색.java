import java.util.*;

class Solution {
     Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        map = new HashMap<>();


        for (String strs : info) {
            dfs(strs.split(" "),"",0);
        }
        for (List<Integer> value : map.values()) {
            value.sort(Integer::compareTo);
        }


        for (String q : query) {
            String[] str = q.replace("and ","").split(" ");

            String key = new StringBuilder(str[0]).append(str[1]).append(str[2]).append(str[3]).toString();
            int findScore = Integer.parseInt(str[4]);
            int start = 0;
            List<Integer> list = map.get(key);

            if (list == null) {
                answer.add(0);
                continue;
            }
            int end = list.size()-1;

            while (start <= end) {
                int mid = (start + end)/2;

                if (list.get(mid) >= findScore) {
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }


            answer.add(list.size() - start);
        }

        return answer.stream().mapToInt(i ->i).toArray();
    }


    private void dfs(String[] strs, String str, int count) {

        if (count == 4) {

            if (!map.containsKey(str)) {
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(strs[4]));
            return;
        }

        dfs(strs,str+strs[count],count+1);
        dfs(strs,str+"-",count+1);
    }

}