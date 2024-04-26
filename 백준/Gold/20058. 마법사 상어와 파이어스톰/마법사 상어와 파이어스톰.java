import java.util.*;
import java.io.*;

public class Main {

	static int len;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		int[][] board = getBoard();
		System.out.println(getTotalIce(board));
		System.out.println(getMaxIce(board));
	}

	static int getMaxIce(int[][] board) {
		boolean[][] visited = new boolean[len][len];
		int max = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (!visited[i][j] && board[i][j] > 0) {
					visited[i][j] = true;
					max = Math.max(max, bfs(board, visited, i, j));
				}
			}
		}

		return max;
	}

	static int bfs(int[][] board, boolean[][] visited, int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (0 <= nx && nx < len && 0 <= ny && ny < len) {
					if (!visited[nx][ny] && board[nx][ny] > 0) {
						visited[nx][ny] = true;
						cnt++;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}

		return cnt;
	}

	static int getTotalIce(int[][] board) {
		int cnt = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				cnt += board[i][j];
			}
		}

		return cnt;
	}

	static int[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		len = (int)Math.pow(2, N);
		int[][] board = new int[len][len];

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			board = turn(board, L);
			board = melt(board);
		}

		return board;
	}

	static int[][] turn(int[][] board, int L) {
		L = (int)Math.pow(2, L);
		int[][] temp = new int[len][len];

		for (int i = 0; i < len; i += L) {
			for (int j = 0; j < len; j += L) {
				rotate(board, temp, L, i, j);
			}
		}

		return temp;
	}

	static void rotate(int[][] board, int[][] temp, int L, int x, int y) {
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				temp[i + x][j + y] = board[L - 1 - j + x][i + y];
			}
		}
	}

	static int[][] melt(int[][] board) {
		int[][] temp = new int[len][len];
		for (int i = 0; i < len; i++) temp[i] = Arrays.copyOf(board[i], len);

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] == 0) continue;

				int cnt = 0;

				for (int d = 0; d < 4; d++) {
					int ni = i + dx[d];
					int nj = j + dy[d];

					if (0 <= ni && ni < len && 0 <= nj && nj < len) {
						if (board[ni][nj] > 0) cnt++;
					}
				}

				if (cnt < 3) temp[i][j]--;
			}
		}

		return temp;
	}

}