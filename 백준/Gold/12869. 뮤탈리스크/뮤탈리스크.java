import java.util.*;
import java.io.*;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int[][] patterns = {
			new int[] {-9, -3, -1},
			new int[] {-9, -1, -3},
			new int[] {-3, -9, -1},
			new int[] {-3, -1, -9},
			new int[] {-1, -9, -3},
			new int[] {-1, -3, -9}
	};

	public static void main(String[] args) throws Exception {
		int[] scv = getScv();
		dp(scv);
		System.out.println(min);
	}

	static void dp(int[] scv) {
		int[][][] dp = new int[61][61][61];
		dfs(scv, dp, 0);
	}

	static void dfs(int[] scv, int[][][] dp, int attackCnt) {
		if (attackCnt >= min) return;

		int o1 = Math.max(scv[0], 0);
		int o2 = Math.max(scv[1], 0);
		int o3 = Math.max(scv[2], 0);

		if (dp[o1][o2][o3] != 0 && dp[o1][o2][o3] <= attackCnt) return;
		dp[o1][o2][o3] = attackCnt;

		if (o1 == 0 && o2 == 0 && o3 == 0) {
			min = Math.min(min, attackCnt);
		}

		for (int[] pattern : patterns) {
			dfs(new int[] {o1 + pattern[0], o2 + pattern[1], o3 + pattern[2]}, dp, attackCnt + 1);
		}
	}

	static int[] getScv() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scv = new int[3];

		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		return scv;
	}
}