import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            int index = map.get(call);
            String str = players[index - 1];
            players[index - 1] = players[index];
            players[index] = str;
            map.put(call,index-1);
            map.put(str,index);
        }

        return players;
    }
}