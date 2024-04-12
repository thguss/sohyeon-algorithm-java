import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());
		int[][] dp = dp();
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n][1] + dp[n][2] + dp[n][3]).append("\n");
		}

		System.out.println(sb);

	}

	static int[][] dp() {
		int[][] dp = new int[10001][4];

		dp[1][1] = 1; // 1

		dp[2][1] = 1; // 1 + 1
		dp[2][2] = 1; // 2

		dp[3][1] = 1; // 1 + 1 + 1
		dp[3][2] = 1; // 1 + 2
		dp[3][3] = 1; // 3


		for (int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i - 1][1];
			dp[i][2] = dp[i - 2][2] + dp[i - 2][1];
			dp[i][3] = dp[i - 3][3] + dp[i - 3][2] + dp[i - 3][1];
		}

		return dp;
	}

}