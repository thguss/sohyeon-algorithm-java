import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String name : participant) {
            if (!map.containsKey(name)) map.put(name, 0);
            map.put(name, map.get(name) + 1);
        }
    
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) > 0) return key;
        }
        
        String answer = "";
        return answer;
    }
}