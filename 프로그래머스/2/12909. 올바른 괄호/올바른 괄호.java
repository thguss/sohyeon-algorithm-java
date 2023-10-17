import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                if (s.charAt(i) == ')') return false;
                else stack.push(s.charAt(i));
            } else { // stack
                if (s.charAt(i) == '(') stack.push(s.charAt(i));
                else { // ")"
                    char c = stack.pop(); // "("
                    if (c == ')') return false;
                }
            }
        }
        
        // System.out.println(stack);
        
        if (!stack.isEmpty()) return false;

        return true;
    }
}