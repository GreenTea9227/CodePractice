import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing((Node node) -> node.len,Comparator.reverseOrder())
                .thenComparing(node -> node.start)
                .thenComparing(node -> node.index));

        m = change(m);
        
        for (int i=0;i<musicinfos.length;i++) {
            String[] music = musicinfos[i].split(",");
            music[3] = change(music[3]);
            int re = timeLogic(music[0],music[1]);
            if (repeatStr(music[3],re,m)) {
                queue.offer(new Node(re,music[0],i,music[2]));
            }

        }
        return queue.isEmpty() ? "(None)" : queue.poll().musicName;
    }
    
    private String change(String strs) {
        return strs.replace("C#","J")
                .replace("D#","k")
                .replace("F#","L")
                .replace("G#","N")
                .replace("A#","M");
    }
    
    private  int timeLogic(String t1, String t2) {
        String[] time1 = t1.split(":");
        String[] time2 = t2.split(":");

        return (Integer.parseInt(time2[0]) - Integer.parseInt(time1[0]) )*60 +
                Integer.parseInt(time2[1]) - Integer.parseInt(time1[1]);
    }

    private  boolean repeatStr(String str,int num,String m) {
       return (str.repeat(num /str.length()) + str.substring(0,num % str.length())).contains(m);
    }

    static class Node {
        int len;
        String start;
        int index;
        String musicName;

        public Node(int len, String start, int index,String musicName) {
            this.len = len;
            this.start = start;
            this.index = index;
            this.musicName = musicName;
        }
    }
}