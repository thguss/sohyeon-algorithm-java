import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String msg) {
        int mapIdx = initMap();
        List<Integer> al = new ArrayList<>();
        int idx = 0;
        
        while (idx < msg.length()) {
            String str = "";
            
            while (idx < msg.length()) {
                if (map.containsKey(str + msg.charAt(idx))) {
                    str += msg.charAt(idx);
                } else {
                    break;
                }
                idx++;
            }
            
            al.add(map.get(str));
            
            if (idx < msg.length()) {
                map.put(str + msg.charAt(idx), mapIdx++);
            }
        }
        
        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        
        return answer;
    }
    
    private int initMap() {
        int idx = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf((char)i), idx++);
        }
        return idx;
    }
}