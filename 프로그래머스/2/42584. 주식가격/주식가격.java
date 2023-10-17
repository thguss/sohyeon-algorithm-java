import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // System.out.println(stack);
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i); // 가격이 떨어지지 않았을 때
        }
        
        // System.out.println("test");
        
        while (!stack.isEmpty()) {
            // System.out.println(stack);
            answer[stack.peek()] = (prices.length - 1) - stack.peek();
            stack.pop();
        }
        
        return answer;
    }
}