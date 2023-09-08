import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliever = 0;
        int pickup = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;
            if (deliveries[i] > 0 || pickups[i] > 0) { // 들려야한다
                while (deliever < deliveries[i] || pickup < pickups[i]) { // 배달 및 수거 완료까지 deliever, pickup 둘 중 하나라도 남아있으면 들린다.
                    cnt++;
                    deliever += cap;
                    pickup += cap;
                }
                deliever -= deliveries[i]; // 남는 자리
                pickup -= pickups[i]; // 남는 자리
                answer += (i + 1) * cnt * 2; // 거리 * 횟수 * 왕복
            }
        }
        return answer;
    }
}