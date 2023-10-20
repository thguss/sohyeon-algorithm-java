import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i < s.length; i++) {
            answer[i] = solve(s[i]);
        }
        return answer;
    }
    
    private String solve(String str) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char z = str.charAt(i);
            
            if (stack.size() >= 2) {
                char y = stack.pop();
                char x = stack.pop();
                
                if (x == '1' && y == '1' && z == '0') {
                    cnt++;
                } else { // 확인하고 아니면 다시 넣기
                    stack.push(x);
                    stack.push(y);
                    stack.push(z);
                }
            } else {
                stack.push(z);
            }
        }
        
        int idx = stack.size();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            if(!flag && stack.peek() == '1') {
                idx--;
            }
            
            if(!flag && stack.peek() == '0') {
                flag = true;
            }
            
            sb.insert(0, stack.pop()); // 왼쪽에 삽입
        }
            
        if (cnt > 0) {
            while(cnt-- > 0) {
                sb.insert(idx, "110");
                idx += 3;
            }
        }
            
        return sb.toString();
    }
}