
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;

		while (true) {
			// print();
			bfs(0, 0);
			time++;
			// System.out.println();
			if (isClear()) break;
		}

		// print();

		System.out.println(time);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (visited[nx][ny] || board[nx][ny] == 1) continue;
					visited[nx][ny] = true;
					board[nx][ny] = -1;
					queue.offer(new int[] {nx, ny});
				}
			}
		}

		meltCheese();
	}

	private static void meltCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && isMelt(i, j)) {
					board[i][j] = 0;
				}
			}
		}
	}

	private static boolean isMelt(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (board[nx][ny] == -1) cnt++;
			}
		}
		return cnt >= 2;
	}

	private static boolean isClear() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) return false;
			}
		}
		return true;
	}

	private static void print() {
		for (int[] arr : board) {
			System.out.println(Arrays.toString(arr));
		}
	}

}