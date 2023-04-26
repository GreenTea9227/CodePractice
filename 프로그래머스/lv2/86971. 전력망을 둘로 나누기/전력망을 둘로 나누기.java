import java.util.*;

class Solution {
     
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i=1;i<=n;i++) {
            map.put(i,new ArrayList<Integer>());
        }
        for (int[] ints : wires) {
            int first = ints[0];
            int second = ints[1];
            
            List<Integer> list1 = map.getOrDefault(first,new ArrayList<>());
            list1.add(second);
            
            List<Integer> list2 = map.getOrDefault(second,new ArrayList<>());
            list2.add(first);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i=1;i<=n;i++) {
            int start = i; 
            
            for (int next : map.get(start)) {
                
                int count = 1;
                boolean[] check = new boolean[n+1];
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(next);
                check[next]=true;
                
                while (!queue.isEmpty()) {
                    
                    int cur = queue.poll();
                    
                    for (int nextValue : map.get(cur)) {
                        
                        if (nextValue != start && !check[nextValue]) {
                            queue.offer(nextValue);
                            check[nextValue]=true;
                            count++;
                        }
                    }
                }
                
                ans = Math.min(ans,Math.abs(n-2*count));
            }

        }
    
        return ans;
    }
    

}