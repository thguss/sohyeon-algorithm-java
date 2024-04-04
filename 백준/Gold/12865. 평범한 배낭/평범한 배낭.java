import java.util.*;
import java.io.*;

public class Main {
	static int N, K;

	public static void main(String[] args) throws Exception {
		int[][] arr = getArr();
		System.out.println(dp(arr));
	}

	static int dp(int[][] arr) {
		int[][] dp = new int[N + 1][K + 1];

		for (int j = 1; j <= K; j++) { // 무게
			for (int i = 1; i <= N; i++) { // 물품 수
				dp[i][j] = dp[i - 1][j];
				if (j >= arr[i][0]) { // 물품 담을 수 있는 지 확인
					int remain = j - arr[i][0]; // 더 채울 수 있는 무게
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][remain] + arr[i][1]); // 더 채울 수 있는 무게 중 최대 가치 + 현 가치
				}
			}
		}

		return dp[N][K];
	}

	static int[][] getArr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 물품의 수
		K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

		int[][] arr = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		return arr;
	}

}