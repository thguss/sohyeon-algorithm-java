import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<Long> al = new ArrayList<>();
    
    public int solution(String numbers) {
        for (int i = 1; i <= numbers.length(); i++) {
            visited = new boolean[numbers.length()];
            permutation(numbers, "", i);
        }
        
        System.out.println(al);
        
        int answer = 0;
        
        for (long num : al) {
            // System.out.println(num + " " + isPrime(num));
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num == 1 || num == 0) return false;
        
        for (int i = 2; i <= num / 2; i++) {
            // System.out.println(num + " " + i + " " + num % i);
            if (num % i == 0) return false;
        }
        
        return true;
    }
    
    private void permutation(String numbers, String str, int cnt) {
        if (str.length() == cnt) {
            long num = Long.valueOf(str);
            if (!al.contains(num)) al.add(num);
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permutation(numbers, str + numbers.charAt(i), cnt);
            visited[i] = false;
        }
    }
}