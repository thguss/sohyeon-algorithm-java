import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int N = getN();
		System.out.println(dp(N));
	}

	static int dp(int N) {
		if (N == 1) return 0;
		else if (N == 2 || N == 3) return 1;

		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= N; i++) {
			if (i % 2 == 0 && dp[i] > dp[i / 2]) {
				dp[i] = dp[i / 2] + 1;
			}
			if (i % 3 == 0 && dp[i] > dp[i / 3]) {
				dp[i] = dp[i / 3] + 1;
			}
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}

		return dp[N];
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		return Integer.parseInt(br.readLine());
	}

}