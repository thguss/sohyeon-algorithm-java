import java.util.*;
import java.io.*;

public class Main {

	static int W, H;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

	static String solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			Queue<int[]> fires = new LinkedList<>();
			int[][] fired = new int[H][W];

			char[][] board = new char[H][W];
			int x = 0;
			int y = 0;

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					board[i][j] = str.charAt(j);
					if (board[i][j] == '@') {
						x = i;
						y = j;
						board[i][j] = '.';
					} else if (board[i][j] == '*') {
						fires.add(new int[] {i, j});
						fired[i][j] = 1;
					}
				}
			}

			fire(board, fires, fired);
			sb.append(bfs(board, fired, x, y)).append("\n");
		}

		return sb.toString();
	}

	static String bfs(char[][] board, int[][] fired, int x, int y) {
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.add(new int[] {x, y, 1});

		boolean[][] visited = new boolean[H][W];
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (0 <= nx && nx < H && 0 <= ny && ny < W) {
					if (!visited[nx][ny] && board[nx][ny] == '.') {
						if (cur[2] + 1 < fired[nx][ny] || fired[nx][ny] == 0) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx, ny, cur[2] + 1});
						}
					}
				} else {
					return String.valueOf(cur[2]);
				}
			}
		}

		return "IMPOSSIBLE";
	}

	static void fire(char[][] board, Queue<int[]> fires, int[][] fired) {
		while(!fires.isEmpty()) {
			int[] cur = fires.poll();

			for (int k = 0; k < 4; k++) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];
				if (0 <= nx && nx < H && 0 <= ny && ny < W && board[nx][ny] == '.' && fired[nx][ny] == 0) {
					fires.add(new int[] {nx, ny});
					fired[nx][ny] = fired[cur[0]][cur[1]] + 1;
				}
			}
		}
	}

}