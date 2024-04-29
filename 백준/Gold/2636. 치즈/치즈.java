import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		int[][] board = getBoard();

		int time = 0;

		while (isExistCheese(board)) {
			melt(board);
			time++;
		}

		System.out.println(time);
		System.out.println(cnt);
	}

	static void melt(int[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});

		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (board[cur[0]][cur[1]] == 1) {
				board[cur[0]][cur[1]] = 0;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}

	static boolean isExistCheese(int[][] board) {
		int cheeseCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) cheeseCount++;
			}
		}

		if (cheeseCount > 0) {
			cnt = cheeseCount;
			return true;
		}

		return false;
	}

	static int[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		return board;
	}

}