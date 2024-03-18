import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		int[][] chapters = getChapters();
		System.out.println(dp(chapters));
	}

	static int dp(int[][] chapters) {
		int[][] dp = new int[M + 1][N + 1]; // [챕터][일] = 최대 페이지

		for (int i = 1; i <= M; i++) {
			int day = chapters[i][0];
			int page = chapters[i][1];

			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= day) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - day] + page);
				}
			}
		}

		return dp[M][N];
	}

	static int[][] getChapters() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 독서 일수
		M = Integer.parseInt(st.nextToken()); // 챕터 개수

		int[][] chapters = new int[M + 1][2]; // [일][페이지]

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int page = Integer.parseInt(st.nextToken());
			chapters[i][0] = day;
			chapters[i][1] = page;
		}

		return chapters;
	}
}