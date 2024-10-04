import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] segments = {
        {1, 1, 1, 0, 1, 1, 1}, // 0
        {0, 0, 1, 0, 0, 1, 0}, // 1
        {1, 0, 1, 1, 1, 0, 1}, // 2
        {1, 0, 1, 1, 0, 1, 1}, // 3
        {0, 1, 1, 1, 0, 1, 0}, // 4
        {1, 1, 0, 1, 0, 1, 1}, // 5
        {1, 1, 0, 1, 1, 1, 1}, // 6
        {1, 0, 1, 0, 0, 1, 0}, // 7
        {1, 1, 1, 1, 1, 1, 1}, // 8
        {1, 1, 1, 1, 0, 1, 1}  // 9
    };
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken()); // digit
        int P = Integer.valueOf(st.nextToken()); // chance
        int X = Integer.valueOf(st.nextToken()); // floor

        int[] arr = new int[K];
        int answer = 0;

        int temp = X;
        for (int i = K - 1; i >= 0; i--) {
            arr[i] = temp % 10;
            temp /= 10;
        }

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            
            int[] target = new int[K];
            int floor = i;
            for (int j = K - 1; j >= 0; j--) {
                target[j] = floor % 10;
                floor /= 10;
            }

            int diff = 0;
            for (int l = 0; l < arr.length; l++) {
                for (int j = 0; j < 7; j++) {
                    if (segments[arr[l]][j] != segments[target[l]][j]) {
                        diff++;
                    }
                }
            }

            if (diff <= P) {
                answer++;
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
    }

}