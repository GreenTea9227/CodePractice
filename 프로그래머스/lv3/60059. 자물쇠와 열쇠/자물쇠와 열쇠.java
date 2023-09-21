import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int len = n+m*2-2;
        int[][] map = new int[len][len]; 
        
        for(int i=m-1; i<m+n-1 ; i++){
            for(int j=m-1; j<m+n-1; j++){
                map[i][j] = lock[i-(m-1)][j-(m-1)];
            }
        }
        
        for (int i=0;i<4;i++) { 
            if (check(map, key,lock)) {
                return true;
            }
            rotate(key);
            for (int j=0;j<key.length;j++) {
                System.out.println(Arrays.toString(key[j]));
            }
            System.out.println();
        }
        
        return false;
    }
    

    private boolean check(int[][] map,int[][] key,int[][] lock) {
        int keyLen = key.length;
        int mapLen = map.length;
        for (int i=0;i<mapLen - keyLen +1;i++) {
            for (int j=0;j<mapLen - keyLen + 1;j++) {
                
                for (int k=0;k<keyLen;k++) {
                    for (int l =0; l<keyLen;l++) {
                        map[i+k][j+l] += key[k][l]; 
                    }
                }
                
                if (check(map,keyLen,lock.length)) {
                    return true;
                }
                 
                for(int k=0; k<keyLen; k++){
                    for(int l=0; l<keyLen; l++){
                        map[i+k][j+l] -= key[k][l];
                    }
                }
            }
        }
            
        return false;
    }
    
    private boolean check(int[][] map,int keyLen,int lockLen) {
        for (int i=keyLen-1;i < lockLen + keyLen -1;i++) {
            for (int j=keyLen-1;j<lockLen + keyLen - 1;j++) {
               if (map[i][j] != 1)
                   return false;
            }
        }
        return true;
    }
    
    private void rotate(int[][] key) {
    
        int n = key.length;
        
        for (int i=0;i<n/2;i++) {
            for (int j=0;j<n;j++) {
                int temp =key[i][j];
                key[i][j] = key[n - i - 1][j];
                key[n-i-1][j] = temp;
            }
        }
        
        
        for (int i=0;i<n;i++) {
            for (int j=i;j<n;j++) {
                int temp =key[i][j];
                key[i][j] = key[j][i];
                key[j][i] = temp;
            }
        }
    }
  
}