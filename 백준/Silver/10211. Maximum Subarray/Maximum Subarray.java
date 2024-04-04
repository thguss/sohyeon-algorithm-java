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

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N + 1];
			int[] dp = new int[N + 1];
			int max = Integer.MIN_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = dp[i - 1] + arr[i];
				max = Math.max(max, Math.max(dp[i], arr[i]));
			}

			sb.append(getMax(arr, dp, max, N)).append("\n");
		}

		System.out.println(sb);
	}

	static int getMax(int[] arr, int[] dp, int max, int N) {
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				max = Math.max(max, dp[j] - dp[i]);
			}
		}

		return max;
	}

}