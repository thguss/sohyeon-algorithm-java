import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		char[][] board = getBoard();
		boolean[] visited = new boolean['Z' - 'A' + 1];
		visited[board[0][0] - 'A'] = true;
		dfs(board, 0, 0, 1, visited);
		System.out.println(max);
	}

	static void dfs(char[][] board, int x, int y, int cnt, boolean[] visited) {
		boolean isGo = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (visited[board[nx][ny] - 'A']) continue;
				isGo = true;
				visited[board[nx][ny] - 'A'] = true;
				dfs(board, nx, ny, cnt + 1, visited);
				visited[board[nx][ny] - 'A'] = false;
			}
		}
		if (!isGo) {
			max = Math.max(max, cnt);
		}
	}

	static char[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		return board;
	}

}