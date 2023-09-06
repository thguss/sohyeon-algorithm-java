import java.util.*;
import java.io.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 거리에 있는 아이들 수
		int M = Integer.parseInt(st.nextToken()); // 아이들의 친구 관계 수
		int K = Integer.parseInt(st.nextToken()); // 울음소리가 공명하기 위한 최소 아이의 수

		int[] c = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) != find(b)) {
				union(a, b);
			}
		}

		int[][] total = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			int p = find(i);
			total[p][0] += c[i];
			total[p][1]++;
		}

		int[] dp = new int[K];

		for (int[] temp : total) {
			int cnt = temp[0]; // 사탕 개수
			int num = temp[1]; // 아이들 개수
			if (cnt == 0) continue;
			for (int i = K - 1; i >= num; i--) {
				dp[i] = Math.max(dp[i], dp[i - num] + cnt);
			}
			// System.out.println(Arrays.toString(temp) + " " + Arrays.toString(dp));
		}

		System.out.println(dp[K - 1]);

	}

	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		if (ra <= rb) {
			parent[rb] = ra;
		} else {
			parent[ra] = rb;
		}
	}
}
