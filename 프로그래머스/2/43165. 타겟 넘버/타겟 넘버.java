import java.util.*;

class Solution {
    
    static int cnt;
    static List<Integer> al = new ArrayList<>();
    
    public int solution(int[] numbers, int target) {
        cnt = 0;
        dfs(numbers, 0, 0, target);
        System.out.println(al);
        return al.size();
    }
    
    private void dfs(int[] numbers, int cnt, int sum, int target) {
        if (cnt == numbers.length) {
            if (sum == target) {
                cnt++;
                al.add(sum);
            }
            return;
        }
        dfs(numbers, cnt + 1, sum + numbers[cnt], target);
        dfs(numbers, cnt + 1, sum - numbers[cnt], target);
    }
}