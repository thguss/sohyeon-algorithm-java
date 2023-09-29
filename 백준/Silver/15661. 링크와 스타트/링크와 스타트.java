import java.util.*;
import java.io.*;

public class Main {

	static int N, res = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[N];
		for (int t = 1; t <= N -1; t++) {
			comb(0, 0, map, t);
			if (res == 0) break;
		}
		System.out.println(res);
	}

	private static void comb(int start, int count, int[][] map, int t) {
		if (res == 0) return;

		if (count == t) {
			res = Math.min(res, diff(map));
			return;
		}

		for (int i = start; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			comb(i + 1, count + 1, map, t);
			visited[i] = false;
		}
	}

	private static int diff(int[][] map) {
		int S = 0, L = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] == visited[j]) {
					if (visited[i]) { // S
						S += (map[i][j] + map[j][i]);
					} else { // L
						L += (map[i][j] + map[j][i]);
					}
				}
			}
		}

		return Math.abs(S - L);
	}
}
