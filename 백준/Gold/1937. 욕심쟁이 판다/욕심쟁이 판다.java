import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		int[][] forest = getForest();
		int[][] dp = new int[N][N];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dfs(forest, dp, i, j));
			}
		}

		System.out.println(max);
	}

	static int dfs(int[][] forest, int[][] dp, int x, int y) {
		if (dp[x][y] != 0) {
			return dp[x][y];
		}

		dp[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				if (forest[nx][ny] > forest[x][y]) {
					dp[x][y] = Math.max(dp[x][y], dfs(forest, dp, nx, ny) + 1); // 메모제이션
				}
			}
		}

		return dp[x][y];
	}

	static int[][] getForest() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		int[][] forest = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		return forest;
	}
}