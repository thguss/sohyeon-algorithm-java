import java.util.*;

class Solution {
    
    static int min = Integer.MAX_VALUE;
    static HashMap<String, List<Integer>> map = new HashMap<>();
    static int mineralLen;
    
    public int solution(int[] picks, String[] minerals) {
        
        mineralLen = minerals.length;
        
        map.put("diamond", List.of(1, 5, 25));
        map.put("iron", List.of(1, 1, 5));
        map.put("stone", List.of(1, 1, 1));
        
        bfs(0, 0, picks, minerals);

        return min;
    }
    
    private void bfs(int depth, int energy, int[] picks, String[] minerals) {
        if (depth == mineralLen || (picks[0]==0 && picks[1]==0 && picks[2]==0)) {
            min = Math.min(min, energy);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;
            
            picks[i]--;
            
            int next = Math.min(depth+5, mineralLen);
            int temp = 0;
            for (int j = depth; j < next; j++) {
                temp += map.get(minerals[j]).get(i);
            }
            
            bfs(next, energy+temp, picks, minerals);
            
            picks[i]++;
        }
    }
}