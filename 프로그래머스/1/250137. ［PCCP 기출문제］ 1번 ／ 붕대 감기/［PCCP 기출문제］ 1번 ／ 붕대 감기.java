class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
          
        int currentHealth = health;
        int time = 0;
        for (int i=0;i<attacks.length;i++) {
            int band = 0;
            //회복
            while (time < attacks[i][0]) {
                band++;
                time++;
                currentHealth =  currentHealth+bandage[1]  ;
                
                if (band == bandage[0]) {
                    currentHealth = currentHealth+bandage[2] ;
                    band = 0;
                }
                if (currentHealth > health)
                    currentHealth = health;            
            }

            
    
            currentHealth -= attacks[i][1];
            if (currentHealth <= 0) {
                return -1;
            }
            time++;
        }
        return currentHealth;
    }
}
