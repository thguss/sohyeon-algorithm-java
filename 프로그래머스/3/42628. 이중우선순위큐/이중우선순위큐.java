import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            if (arr[0].equals("I")) {
                min.add(Integer.valueOf(arr[1]));
                max.add(Integer.valueOf(arr[1]));
            } else {
                if (max.isEmpty()) continue;
                if (arr[1].equals("1")) {
                    int del = max.poll();
                    min.remove(del);
                } else {
                    int del = min.poll();
                    max.remove(del);
                }
            }
        }
        
        return max.isEmpty() ? new int[] {0, 0} : new int[] {max.peek(), min.peek()};
    }
}