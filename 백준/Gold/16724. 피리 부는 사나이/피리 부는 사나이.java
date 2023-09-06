import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited, done;
	static int cnt;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = input.charAt(j);
				if (c == 'U') {
					arr[i][j] = 0;
				} else if (c == 'D') {
					arr[i][j] = 1;
				} else if (c == 'L') {
					arr[i][j] = 2;
				} else {
					arr[i][j] = 3;
				}
			}
		}

		visited = new boolean[N][M];
		done = new boolean[N][M];
		cnt = 0; // 사이클 개수

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
				}
			}
		}

		System.out.println(cnt);

	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		int d = arr[x][y];
		int nx = x + dx[d];
		int ny = y + dy[d];

		if (!visited[nx][ny]) {
			dfs(nx, ny);
		} else {
			if (!done[nx][ny]) {
				cnt++;
			}
		}

		done[x][y] = true;
	}
}
