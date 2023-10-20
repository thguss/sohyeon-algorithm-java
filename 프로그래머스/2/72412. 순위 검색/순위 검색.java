import java.util.*;

class Solution {
    
    static Map<String, List<Integer>> map; // {점수 제외 쿼리, [점수]}
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        for(String str : info) {
            String[] arr = str.split(" ");
            save(arr, "", 0);
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] arr = query[i].split(" ");
            String key = arr[0];
            int score = Integer.valueOf(arr[1]);
            answer[i] = map.containsKey(key) ? bs(key, score) : 0;
        }
        
        return answer;
    }
    
    private int bs(String key, int score) {
        List<Integer> al = map.get(key);
        
        int l = 0;
        int r = al.size() - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if(al.get(mid) < score) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return al.size() - l;
    }
    
    private void save(String[] arr, String str, int cnt) {
        if(cnt == 4) {
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.valueOf(arr[4]));
            return;
        }
        save(arr, str + "-", cnt + 1);
        save(arr, str + arr[cnt], cnt + 1);
    }
}