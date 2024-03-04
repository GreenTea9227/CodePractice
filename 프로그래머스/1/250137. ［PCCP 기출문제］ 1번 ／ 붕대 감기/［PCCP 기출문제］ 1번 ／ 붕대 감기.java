class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
          
        int currentHealth = health;
        int[] intervaltime = new int[attacks.length];
        
        for (int i=0;i<attacks.length-1;i++) {
            intervaltime[i] =  attacks[i+1][0] - attacks[i][0] - 1;
        }
        
        for (int i=0;i<attacks.length;i++) {
            
            currentHealth -= attacks[i][1];
            
            if (currentHealth <= 0)
                return -1;
            
            currentHealth  =  currentHealth +  intervaltime[i] * bandage[1] + 
                (intervaltime[i] / bandage[0]) * bandage[2];

            currentHealth = Math.min(currentHealth,health);
        }
        
        return currentHealth;
    }
}
