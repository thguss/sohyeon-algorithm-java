import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		char[][] board = getBoard();
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'W') continue;
				int distance = bfs(board, i, j);
				max = Math.max(max, distance);
			}
		}

		System.out.println(max);
	}

	static int bfs(char[][] board, int x, int y) {
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y, 0});

		int max = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			max = Math.max(max, cur[2]);

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && board[nx][ny] == 'L') {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}

		return max;
	}

	static char[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = arr[j].charAt(0);
			}
		}

		return board;
	}
}