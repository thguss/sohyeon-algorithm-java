import java.util.*;
import java.io.*;

public class Main {

	static int R, C;

	public static void main(String[] args) throws Exception {
		int[][] board = getBoard();
		System.out.println(bfs(board));
	}

	static int bfs(int[][] board) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {R, C, 0});

		boolean[][] visited = new boolean[5][5];
		visited[R][C] = true;

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (board[cur[0]][cur[1]] == 1) {
				return cur[2];
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[nx][ny] && board[nx][ny] != -1) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}

		return -1;
	}

	static int[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] board = new int[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		return board;
	}

}