import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		int N = getN();
		System.out.println(dp(N));
	}

	static int dp(int N) {
		int[] dp = new int[N + 1];
		if (N >= 3) dp[3] = 1;
		if (N >= 5) dp[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			} else if (i % 3 == 0) {
				dp[i] = dp[i - 3] + 1;
			} else if (dp[i - 5] != 0 && dp[i - 3] != 0) {
				dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			}
		}

		return dp[N] != 0 ? dp[N] : -1;
	}

	static int greedy(int N) {
		int count = 0;

		while (N > 0) {
			if (N % 5 == 0) {
				count += (N / 5);
				return count;
			}

			N -= 3;
			count++;
		}

		return (N == 0) ? count : -1;
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		return Integer.parseInt(br.readLine());
	}

}