import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] cards = getCards();
		System.out.println(dp(cards));
	}

	static int dp(int[] cards) {
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], cards[j] + dp[i - j]); // j개 카드팩 + (i - j)개 카드
			}
		}

		// System.out.println(Arrays.toString(dp));

		return dp[N];
	}

	static int[] getCards() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
	}

}