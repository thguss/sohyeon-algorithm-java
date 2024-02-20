import java.util.*;
import java.io.*;

public class Main {

	static long MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		System.out.println(get15MultipleCount(getN()));
	}

	static long get15MultipleCount(int N) {
		if (N == 1) {
			return 0;
		}

		/**
		 * 15의 배수 : 3의 배수 성질 + 5의 배수 성질
		 * 3의 배수 : 각 자릿수의 합이 3의 배수
		 * 5의 배수 : 1의 자리가 0 또는 5
		 * 정수는 1과 5로만 이루어져 있으므로 1의 자리 5 고정
		 */

		long[][] dp = new long[3][N + 1]; // [3으로 나눈 나머지][자릿수]
		dp[0][2] = 1;
		dp[1][2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % MOD;
			dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % MOD;
			dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % MOD;
		}

		return dp[0][N];
	}

	static int getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return Integer.parseInt(br.readLine());
	}

}