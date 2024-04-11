import java.util.*;
import java.io.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {
		int[][] arr = input();
		System.out.println(dp(arr));
	}

	static int dp(int[][] arr) {
		int[][][] dp = new int[N][M][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				dp[0][i][j] = arr[0][i];
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0) {
					dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
					dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
				} else if (j == M - 1) {
					dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
					dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
				} else {
					dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
					dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
					dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				min = Math.min(min, dp[N - 1][i][j]);
			}
		}

		return min;
	}

	static int[][] input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		return arr;
	}

}