import java.util.*;
import java.io.*;

public class Main {

	static int cnt = 0;
	static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		int N = getN();
		System.out.println(dp(N));
	}

	static long dp(int n) {
		if (n < 1) {
			return 1;
		}

		long[] dp = new long[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1] + 1) % MOD;
		}

		return dp[n];
	}

	static int fibonacci(int n) {
		cnt = (cnt + 1) % MOD;

		if (n < 2) {
			return n;
		}

		return fibonacci(n - 2) + fibonacci(n - 1);
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return Integer.parseInt(br.readLine());
	}
}