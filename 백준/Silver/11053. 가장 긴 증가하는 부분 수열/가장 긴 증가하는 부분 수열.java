
import java.io.*;
import java.util.*;

public class Main {

	static int[] dp, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = LIS(i);
		}


		// System.out.println(Arrays.toString(dp));
		int max = -1;
		for (int n : dp) {
			max = Math.max(n, max);
		}
		System.out.println(max);
	}

	private static int LIS(int num) {
		if (dp[num] == 0) {
			dp[num] = 1;
			for(int i = num - 1; i >= 0; i--) {
				if (arr[i] < arr[num]) {
					dp[num] = Math.max(dp[num], LIS(i) + 1);
				}
			}
		}
		return dp[num];
	}

}