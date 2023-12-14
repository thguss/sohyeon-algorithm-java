import java.util.*;

class Solution {
    Map<Integer, Integer> attackInfo = new HashMap<>();
    int curHealth;
    int endTime;
    int skillTime = 0;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        curHealth = health;
        
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
            endTime = attack[0];
        }
        
        for (int i = 1; i <= endTime; i++) {
            if (attackInfo.containsKey(i)) {
                curHealth -= attackInfo.get(i);
                skillTime = 0;
            } else {
                curHealth += bandage[1];
                skillTime++;
                
                if (skillTime == bandage[0]) {
                    curHealth += bandage[2];
                    skillTime = 0;
                }
                
                if (curHealth > health) {
                    curHealth = health;
                }
            }
            
            if (curHealth <= 0) {
                return -1;
            }
        }

        return curHealth;
    }
}