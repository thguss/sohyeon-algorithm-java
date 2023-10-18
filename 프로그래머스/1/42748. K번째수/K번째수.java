import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for (int[] command : commands) {
            answer[index++] = solve(array, command[0] - 1, command[1] - 1, command[2] - 1);
        }
        
        return answer;
    }
    
    private int solve(int[] arr, int s, int e, int k) {
        List<Integer> al = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            al.add(arr[i]);
        }
        Collections.sort(al);
        return al.get(k);
    }
}