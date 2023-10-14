import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] arr : clothes) {
            if (!map.containsKey(arr[1])) map.put(arr[1], 0);
            map.put(arr[1], map.get(arr[1]) + 1);
        }
        
        int answer = 1;
        
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1;
    }
}