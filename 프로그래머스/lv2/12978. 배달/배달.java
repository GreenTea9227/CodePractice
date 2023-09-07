import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Map<Integer,List<Node>> map = new HashMap<>();
        IntStream.rangeClosed(0,N).forEach(i -> map.put(i,new ArrayList<>()));
        
        for (int[] r : road) {
            map.get(r[0]).add(new Node(r[1],r[2]));
            map.get(r[1]).add(new Node(r[0],r[2]));
        }
        
        Queue<Node> queue = new PriorityQueue<>((a,b) -> a.value-b.value);
        queue.offer(new Node(1,0));
        distance[1] = 0;
        
        boolean[] visited = new boolean[N+1];
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int cur = node.node;
            if (!visited[cur]) {
                 visited[cur] = true;
                for (Node next :  map.get(cur)) {
                    if (distance[next.node] > distance[cur] + next.value) {
                        distance[next.node] = distance[cur] + next.value;
                        queue.offer(new Node(next.node,distance[next.node]));
                    }
                }
            }
                            
        }
       
        return (int)Arrays.stream(distance).filter(i -> i<=K).count();
    }
    
    static class Node {
        int node;
        int value;
        
        Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}