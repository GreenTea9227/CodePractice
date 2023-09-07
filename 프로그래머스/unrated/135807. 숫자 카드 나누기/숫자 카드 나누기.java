import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int numA = arrayA[0];
        int numB = arrayB[0];
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        
        for (int i=2;i<=numA;i++) {
            if (numA % i == 0) {
                setA.add(i);
            }
        }
        
        for (int i=2;i<=numB;i++) {
            if (numB % i != 0)
                continue;
            
            if (setA.contains(i)) {
                setA.remove(i);
            } else {
                setB.add(i);
            }
        }
        
        for (int a : setA) {
            if (check(arrayA,arrayB,a)) {
                answer = Math.max(a,answer);
            }
        }
        for (int a : setB) {
            if (check(arrayB,arrayA,a)) {
                answer = Math.max(a,answer);
            }
        }
        
        
        return answer;
    }
    
    private boolean check(int[] arrayA , int[] arrayB,int num) {
        for (int i=0;i<arrayA.length;i++) {
            if (arrayA[i] % num != 0 || arrayB[i]%num == 0)
                return false;
        }
        return true;
    }
}