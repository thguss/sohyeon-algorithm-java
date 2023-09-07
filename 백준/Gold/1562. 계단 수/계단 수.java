import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int MOD = 1000000000;

		long[][][] dp = new long[N + 1][11][1 << 10]; // 자릿수, 끝자리 수, 비트마스킹
		for (int i = 1; i <= 9; i++) { // 0으로 시작하면 계단수 X
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) { // 자릿수
			for (int j = 0; j <= 9; j++) { // 끝나는 숫자
				for (int k = 0; k < 1024; k++) { // 비트마스킹 (사용한 수 1 표시)
					int bit = k | (1 << j);
					if (j == 0) { // 0으로 끝난다.
						dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
					} else if (j == 9) { // 9로 끝난다.
						dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
					} else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % MOD;
					}
				}
			}
		}

		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + dp[N][i][1023]) % MOD; // N 자릿수, i로 끝나는 수, 0~9 모두 쓴 비트 마스킹
		}
		System.out.println(sum);
	}
}
