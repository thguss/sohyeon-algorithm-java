import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int cnt = 0, idx = 0, zeroCnt = 0;
        
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) zeroCnt++;
        }
        
        for (int i = zeroCnt; i < 6; i++) {
            if (idx >= 6) break;
            while (lottos[i] >= win_nums[idx]) {
                if (lottos[i] == win_nums[idx]) cnt++;
                idx++;
                if (idx >= 6) break;
            }
        }
        
        return new int[] {solve(cnt + zeroCnt), solve(cnt)};
    }
    
    private int solve(int cnt) {
        if(cnt == 6) return 1;
        else if(cnt == 5) return 2;
        else if(cnt == 4) return 3;
        else if(cnt == 3) return 4;
        else if(cnt == 2) return 5;
        else return 6;
    }
}