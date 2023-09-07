import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] W, dp;
	static int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(dfs(0, 1));

	}

	private static int dfs(int c, int check) {
		if (check == (1 << N) - 1) { // 전체 방문
			return W[c][0] != 0 ? W[c][0] : INF;
		}

		if (dp[c][check] != -1) {
			return dp[c][check];
		}

		dp[c][check] = INF;

		for (int i = 0; i < N; i++) {
			int next = check | (1 << i);
			if (W[c][i] == 0 || (check & (1 << i)) != 0) {
				continue;
			}
			dp[c][check] = Math.min(dp[c][check], dfs(i, next) + W[c][i]);
		}

		return dp[c][check];
	}
}
