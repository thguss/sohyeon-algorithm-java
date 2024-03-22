import java.util.*;
import java.io.*;

public class Main {

	static class Position implements Comparable<Position> {
		int x;
		int y;
		int cost;

		Position(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Position p) {
			return this.cost - p.cost;
		}
	}

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		System.out.println(input());
	}

	static String input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int num = 1;
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) break;

			int[][] board = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solve(sb, num, N, board);
			sb.append("\n");
			num++;
		}

		return sb.toString();
	}

	static void solve(StringBuilder sb, int i, int N, int[][] board) {
		sb.append("Problem ").append(i).append(": ").append(bfs(N, board));
	}

	static int bfs(int N, int[][] board) {
		int[][] move = new int[N][N];
		for (int[] arr : move) Arrays.fill(arr, Integer.MAX_VALUE);
		move[0][0] = board[0][0];

		Queue<Position> queue = new PriorityQueue<>();
		queue.add(new Position(0, 0, board[0][0]));

		while (!queue.isEmpty()) {
			Position cur = queue.poll();

			if (cur.x == N - 1 && cur.y == N - 1) {
				return cur.cost;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (move[nx][ny] > cur.cost + board[nx][ny]) {
						move[nx][ny] = board[nx][ny] + cur.cost;
						queue.add(new Position(nx, ny, move[nx][ny]));
					}
				}
			}
		}

		return -1;
	}

}