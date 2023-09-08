class Solution {
    int[] nx = new int[]{0,0,1,-1};
    int[] ny = new int[]{1,-1,0,0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i=0;i<5;i++) {
            if (check(places[i]))
                answer[i]=1;
        }
        return answer;
    }
    
    public boolean check(String[] strs) {
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if (strs[i].charAt(j) == 'O' || strs[i].charAt(j) == 'X')
                    continue;
                boolean[][] visited =new boolean[5][5];
                visited[i][j] =true;
                if (!dfs(strs,0,j,i,visited)) {    
                    return false;
                }
                    
            }
        }
        return true;
    }
    
    public boolean dfs(String[] strs,int distance,int x,int y,boolean[][] visited) {
        if (distance == 2)
            return true;
        
        boolean ans = true;

        for (int i=0;i<4;i++) {
            int xx = nx[i] + x;
            int yy = ny[i] + y;
                    
            if (xx<0 || xx>=5 || yy<0 || yy>=5 || visited[yy][xx])
                continue;
            
            char current = strs[yy].charAt(xx);
            
            if ( current == 'P') 
                return false;
            
                
            visited[yy][xx] =true;
            if ( current == 'O') 
                 ans = ans && dfs(strs,distance+1,xx,yy,visited);
            
        }
               
        return ans;
    }

}