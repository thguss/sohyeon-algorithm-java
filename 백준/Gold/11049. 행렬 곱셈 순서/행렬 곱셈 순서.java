import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] mat = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solve(mat));

	}

	private static int solve(int[][] mat) {
		int[][] dp = new int[mat.length][mat.length];

		for (int i = 0; i < dp.length - 1; i++) {
			dp[i][i + 1] = mat[i][0] * mat[i][1] * mat[i + 1][1];
		}

		for (int i = 2; i < mat.length; i++) { // 구간 거리
			for (int j = 0; j + i < mat.length; j++) { // 0 ~ N-구간
				dp[j][j + i] = Integer.MAX_VALUE;
				for (int k = j; k < j + i; k++) { // j ~ j+구간
					dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + mat[j][0] * mat[k][1] * mat[j + i][1]);
				}
			}
		}

		return dp[0][mat.length - 1];
	}
}
