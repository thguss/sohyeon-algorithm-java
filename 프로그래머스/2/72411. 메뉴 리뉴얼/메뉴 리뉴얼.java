import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static List<String> keys = new ArrayList<>();
    static List<String> al;
    static int max;
    
    public String[] solution(String[] orders, int[] course) {
        for(String order : orders) {
            String[] arr = order.split("");
            for(String str : arr) {
                if(!map.containsKey(str)) {
                    map.put(str, 0);
                }
                map.put(str, map.get(str) + 1);
            }
        }
        
        for(String key : map.keySet()) {
            keys.add(key);
        }
        
        Collections.sort(keys);
        
        List<String> menu = new ArrayList<>();
        
        for(int size : course) {
            al = new ArrayList<>();
            max = 0;
            comb(0, size, "", orders);
            for(String s : al) {
                menu.add(s);
            }
        }
        

        Collections.sort(menu);

        
        String[] answer = new String[menu.size()];
        
        for(int i = 0; i < menu.size(); i++) {
            answer[i] = menu.get(i);
        }
        
        return answer;
    }
    
    private void comb(int start, int size, String str, String[] orders) {
        if(str.length() == size) {
            int cnt = eat(str, orders);
            if(cnt >= 2 && cnt >= max) {
                if(cnt > max) {
                    al = new ArrayList<>();
                    max = cnt;
                }
                al.add(str);
            }
            return;
        }
        
        for(int i = start; i < keys.size(); i++) {
            if(map.get(keys.get(i)) < 2) continue;
            comb(i + 1, size, str + keys.get(i), orders);
        }
        
    }
    
    private int eat(String str, String[] orders) {
        int cnt = 0;
        for(String order : orders) {
            if(match(str, order)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private boolean match(String str, String order) {
        for(int i = 0; i < str.length(); i++) {
            if(!order.contains(Character.toString(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}