import java.util.*;
import java.io.*;

public class Main {
	static int N, M, T;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		int[][] board = getBoard();
		int distance = bfs(board);
		StringBuilder sb = new StringBuilder();
		if (distance == -1 || distance > T) {
			sb.append("Fail");
		} else {
			sb.append(distance);
		}
		System.out.println(sb);
	}

	static int bfs(int[][] board) {
		boolean[][][] visited = new boolean[N][M][2];
		visited[0][0][board[0][0] == 2 ? 1 : 0] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 0, (board[0][0] == 2) ? 1 : 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			// System.out.println(Arrays.toString(cur));

			int x = cur[0];
			int y = cur[1];
			int distance = cur[2];
			boolean haveGram = (cur[3] == 1);

			if (cur[0] == N - 1 && cur[1] == M - 1) {
				return cur[2];
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (haveGram) {
					if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny][1]) {
						visited[nx][ny][1] = true;
						queue.add(new int[] {nx, ny, distance + 1, 1});
					}
				} else {
					if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny][0] && board[nx][ny] != 1) {
						visited[nx][ny][0] = true;
						queue.add(new int[] {nx, ny, distance + 1, (board[nx][ny] == 2) ? 1 : 0});
					}
				}
			}
		}

		return -1;
	}

	static int[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

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