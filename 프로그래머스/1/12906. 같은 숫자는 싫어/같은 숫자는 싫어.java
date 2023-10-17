import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                al.add(arr[i]);
            } else {
                if (stack.peek() == arr[i]) continue;
                stack.push(arr[i]);
                al.add(arr[i]);
            }
        }
        int[] res = new int[al.size()];
        for(int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;
    }
}