import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        int[] eat = new int[d + 1];
        int count = 0;

        // 초기화
        for (int i = 0; i < k; i++) {
            if (eat[arr[i]] == 0) count++;
            eat[arr[i]]++;
        }

        int max = count;
        if (eat[c] == 0) max++;

        // 슬라이딩 윈도우 (+ 원형 처리)
        for (int i = 0; i < N; i++) {
            int left = i;
            eat[arr[left]]--;
            if (eat[arr[left]] == 0) count--;

            int right = (i + k) % N; // 회전 처리
            if (eat[arr[right]] == 0) count++;
            eat[arr[right]]++;

            int currentMax = count;
            if (eat[c] == 0) currentMax++;

            max = Math.max(max, currentMax);
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}