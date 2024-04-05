import java.util.*;
import java.io.*;

public class Main {
	static int R, C;
	static int[] M, Z;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		char[][] board = getBoard();
		System.out.println(solve(board));
	}

	static String solve(char[][] board) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] != '.') continue;

				board[i][j] = '|';
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " |";
				}
				board[i][j] = '.';

				board[i][j] = '-';
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " -";
				}
				board[i][j] = '.';

				board[i][j] = '+';
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " +";
				}
				board[i][j] = '.';

				board[i][j] = '1';
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " 1";
				}
				board[i][j] = '.';

				board[i][j] = '2';
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " 2";
				}
				board[i][j] = '.';

				board[i][j] = '3';
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " 3";
				}
				board[i][j] = '.';

				board[i][j] = '4';
				// System.out.println((i + 1) + " " + (j + 1));
				if (isFlow(board)) {
					return (i + 1) + " " + (j + 1) + " 4";
				}
				board[i][j] = '.';
				// System.out.println("===");
			}
		}

		return "";
	}

	static boolean isFlow(char[][] board) {
		Queue<int[]> queue = new LinkedList<>();

		boolean[][] visited = new boolean[R][C];
		visited[M[0]][M[1]] = true;

		for (int i = 0; i < 4; i++) {
			int nx = M[0] + dx[i];
			int ny = M[1] + dy[i];
			if (0 <= nx && nx < R && 0 <= ny && ny < C && board[nx][ny] != '.') {
				queue.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			// System.out.println(Arrays.toString(cur) + " " + board[cur[0]][cur[1]]);

			char ch = board[cur[0]][cur[1]];

			// if (ch == 'Z') return true;

			if (ch == '|') {
				if (cur[0] == 0 || cur[0] == R - 1) return false;

				// up
				int up = cur[0] - 1;
				char next = board[up][cur[1]];
				if (next == '.' || next == '-' || next == '2' || next == '3') return false;

				// down
				int down = cur[0] + 1;
				next = board[down][cur[1]];
				if (next == '.' || next == '-' || next == '1' || next == '4') return false;

				if (!visited[up][cur[1]]) {
					visited[up][cur[1]] = true;
					queue.add(new int[] {up, cur[1]});
				}

				if (!visited[down][cur[1]]) {
					visited[down][cur[1]] = true;
					queue.add(new int[] {down, cur[1]});
				}
			}

			else if (ch == '-') {
				if (cur[1] == 0 || cur[1] == C - 1) return false;

				// left
				int left = cur[1] - 1;
				char next = board[cur[0]][left];
				if (next == '.' || next == '|' || next == '3' || next == '4') return false;

				// right
				int right = cur[1] + 1;
				next = board[cur[0]][right];
				if (next == '.' || next == '|' || next == '1' || next == '2') return false;

				if (!visited[cur[0]][left]) {
					visited[cur[0]][left] = true;
					queue.add(new int[] {cur[0], left});
				}

				if (!visited[cur[0]][right]) {
					visited[cur[0]][right] = true;
					queue.add(new int[] {cur[0], right});
				}
			}

			else if (ch == '+') {
				if (cur[0] == 0 || cur[0] == R - 1 && cur[1] == 0 || cur[1] == C - 1) return false;

				// up
				int up = cur[0] - 1;
				char next = board[up][cur[1]];
				if (next == '.' || next == '-' || next == '2' || next == '3') return false;

				// down
				int down = cur[0] + 1;
				next = board[down][cur[1]];
				if (next == '.' || next == '-' || next == '1' || next == '4') return false;

				// left
				int left = cur[1] - 1;
				next = board[cur[0]][left];
				if (next == '.' || next == '|' || next == '3' || next == '4') return false;

				// right
				int right = cur[1] + 1;
				next = board[cur[0]][right];
				if (next == '.' || next == '|' || next == '1' || next == '2') return false;

				if (!visited[up][cur[1]]) {
					visited[up][cur[1]] = true;
					queue.add(new int[] {up, cur[1]});
				}

				if (!visited[down][cur[1]]) {
					visited[down][cur[1]] = true;
					queue.add(new int[] {down, cur[1]});
				}

				if (!visited[cur[0]][left]) {
					visited[cur[0]][left] = true;
					queue.add(new int[] {cur[0], left});
				}

				if (!visited[cur[0]][right]) {
					visited[cur[0]][right] = true;
					queue.add(new int[] {cur[0], right});
				}
			}

			else if (ch == '1') {
				if (cur[1] == C - 1 || cur[0] == R - 1) return false;

				// right
				int right = cur[1] + 1;
				char next = board[cur[0]][right];
				if (next == '.' || next == '|' || next == '1' || next == '2') return false;

				// down
				int down = cur[0] + 1;
				next = board[down][cur[1]];
				if (next == '.' || next == '-' || next == '1' || next == '4') return false;

				if (!visited[cur[0]][right]) {
					visited[cur[0]][right] = true;
					queue.add(new int[] {cur[0], right});
				}

				if (!visited[down][cur[1]]) {
					visited[down][cur[1]] = true;
					queue.add(new int[] {down, cur[1]});
				}
			}

			else if (ch == '2') {
				if (cur[0] == 0 || cur[1] == C - 1) return false;

				// up
				int up = cur[0] - 1;
				char next = board[up][cur[1]];
				if (next == '.' || next == '-' || next == '2' || next == '3') return false;

				// right
				int right = cur[1] + 1;
				next = board[cur[0]][right];
				if (next == '.' || next == '|' || next == '1' || next == '2') return false;

				if (!visited[up][cur[1]]) {
					visited[up][cur[1]] = true;
					queue.add(new int[] {up, cur[1]});
				}

				if (!visited[cur[0]][right]) {
					visited[cur[0]][right] = true;
					queue.add(new int[] {cur[0], right});
				}
			}

			else if (ch == '3') {
				if (cur[0] == 0 || cur[1] == 0) return false;

				// up
				int up = cur[0] - 1;
				char next = board[up][cur[1]];
				if (next == '.' || next == '-' || next == '2' || next == '3') return false;

				// left
				int left = cur[1] - 1;
				next = board[cur[0]][left];
				if (next == '.' || next == '|' || next == '3' || next == '4') return false;

				if (!visited[up][cur[1]]) {
					visited[up][cur[1]] = true;
					queue.add(new int[] {up, cur[1]});
				}

				if (!visited[cur[0]][left]) {
					visited[cur[0]][left] = true;
					queue.add(new int[] {cur[0], left});
				}
			}

			else if (ch == '4') {
				if (cur[1] == 0 || cur[0] == R - 1) return false;

				// down
				int down = cur[0] + 1;
				char next = board[down][cur[1]];
				if (next == '.' || next == '-' || next == '1' || next == '4') return false;

				// left
				int left = cur[1] - 1;
				next = board[cur[0]][left];
				if (next == '.' || next == '|' || next == '3' || next == '4') return false;

				if (!visited[down][cur[1]]) {
					visited[down][cur[1]] = true;
					queue.add(new int[] {down, cur[1]});
				}

				if (!visited[cur[0]][left]) {
					visited[cur[0]][left] = true;
					queue.add(new int[] {cur[0], left});
				}
			}
		}

		return true;
	}

	static char[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == 'M') M = new int[] {i, j};
				else if (board[i][j] == 'Z') Z = new int[] {i, j};
			}
		}

		return board;
	}

}