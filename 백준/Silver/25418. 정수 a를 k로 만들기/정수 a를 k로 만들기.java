import java.util.*;
import java.io.*;

public class Main {
	static int A, K;

	public static void main(String[] args) throws Exception {
		input();
		// System.out.println(bfs(A, K));
		System.out.println(dp(A, K));
	}

	static int dp(int A, int K) {
		int[] dp = new int[K + 1];
		Arrays.fill(dp, 1000001);
		dp[A] = 0;

		for (int i = A + 1; i <= K; i++) {
			dp[i] = dp[i - 1];
			if (i % 2 == 0 && dp[i] > dp[i / 2]) {
				dp[i] = dp[i / 2];
			}
			dp[i]++;
		}

		return dp[K];
	}

	static int bfs(int A, int K) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {A, 0});

		boolean[] visited = new boolean[K + 1];
		visited[A] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == K) {
				return cur[1];
			}

			if (cur[0] + 1 <= K && !visited[cur[0] + 1]) {
				visited[cur[0] + 1] = true;
				queue.add(new int[] {cur[0] + 1, cur[1] + 1});
			}

			if (cur[0] * 2 <= K && !visited[cur[0] * 2]) {
				visited[cur[0] * 2] = true;
				queue.add(new int[] {cur[0] * 2, cur[1] + 1});
			}
		}

		return -1;
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

}