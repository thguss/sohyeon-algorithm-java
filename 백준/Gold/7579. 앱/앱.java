import java.util.*;
import java.io.*;

public class Main { // DP

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N];
		int[] c = new int[N];

		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			sum += c[i];
		}

		int[] dp = new int[sum + 1];
		Arrays.fill(dp, -1);

		for (int i = 0; i < N; i++) {
			int cost = c[i];
			for (int j = dp.length - 1; j >= cost; j--) {
				if (dp[j - cost] != -1) {
					dp[j] = Math.max(dp[j], dp[j - cost] + m[i]);
				}
			}
			dp[cost] = Math.max(dp[cost], m[i]);
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}

	}
}
