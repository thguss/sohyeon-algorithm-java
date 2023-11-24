import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        init();
        
        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            String[] arr = survey[i].split("");
            
            if (choice == 4) {
                continue;
            }
            
            String key = choice <= 4 ? arr[0] : arr[1];
            map.put(key, map.get(key) + Math.abs(4 - choice));
        }
        
        String answer = "";
        
        answer += map.get("R") >= map.get("T") ? "R" : "T";
        answer += map.get("C") >= map.get("F") ? "C" : "F";
        answer += map.get("J") >= map.get("M") ? "J" : "M";
        answer += map.get("A") >= map.get("N") ? "A" : "N";
        
        return answer;
    }
    
    private void init() {
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
    }
}