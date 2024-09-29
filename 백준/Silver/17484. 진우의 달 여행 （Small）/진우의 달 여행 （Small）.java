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
        int M = Integer.valueOf(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = arr[0][j];
            }
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
                } else if (j == M - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + arr[i][j];
                }
            }
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         System.out.print(Arrays.toString(dp[i][j]) + ", ");
        //     }
        //     System.out.println();
        // }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                if (dp[N - 1][j][k] == 0) continue;
                min = Math.min(dp[N - 1][j][k], min);
            }
        }
        
        bw.write(String.valueOf(min));
        bw.flush();
    }

}