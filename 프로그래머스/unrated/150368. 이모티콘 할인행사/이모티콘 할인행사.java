import java.util.*;

class Solution { // 플러스 가입자 늘리기 -> 판매액 늘리기
    static int[] percent = {0, 10, 20, 30, 40};  // 할인율 10% 20% 30% 40%
    static int user_num = 0;
    static int total_price = 0;
    static int min = Integer.MAX_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        for (int[] user : users) {
            min = Math.min(min, user[0]);
        }
        for (int i = 0; i < 5; i++) {
            if (min <= percent[i]) {
                min = i;
                break;
            }
        }
        
        int[] arr = new int[emoticons.length];
        comb(arr, 0, emoticons.length, users, emoticons);
        
        int[] answer = {user_num, total_price}; // 가입 유저 수, 매출액
        return answer;
    }
    
    private void comb(int[] arr, int s, int n, int[][] users, int[] emoticons) {
        if (s == n) {
            cal(users, emoticons, arr);
            return;
        }
        
        for (int i = s; i < n; i++) {
            for (int j = min; j < 5; j++) {
                arr[i] = j;
                comb(arr, i + 1, n, users, emoticons);
            }
        }
        
    }
    
    private void cal(int[][] users, int[] emoticons, int[] arr) {
        int join = 0;
        int price = 0;
        for (int[] temp : users) {
            int p = temp[0]; // 구매할 할인율
            int l = temp[1]; // 구매 한도
            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                if (p > percent[arr[i]]) continue; // p만큼 할인 안하면 pass
                int ep = sale(emoticons[i], percent[arr[i]]); // 할인율 적용된 가격
                total += ep;
            }
            if (l <= total) { // 한도 넘으면 플러스 가입
                join++;
            } else { // 안 넘으면 이모티콘만 구매
                price += total;
            }
        }
        if (join > user_num) {
            user_num = join;
            total_price = price;
        } else if (join == user_num && price > total_price) {
            total_price = price;
        }
    }
    
    private int sale(int price, int percent) {
        return (price) / 100 * (100 - percent);
        // return (int)((double)price * (double)(1 - (double)percent / 100));
    }
    
    private void print(Object obj) {
        System.out.println(obj);
    }
}