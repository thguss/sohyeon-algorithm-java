
import java.io.*;
import java.util.*;

public class Main {

	static int[][] board;
	static int b, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		b = 0;
		w = 0;

		conquer(0, 0, N);

		System.out.println(w + "\n" + b);
	}

	private static void conquer(int x, int y, int s) {
		// System.out.println(x + " " + y + " " + s);
		int color = board[x][y];
		for (int i = x; i < x + s; i++) {
			for (int j = y; j < y + s; j++) {
				if (board[i][j] != color) {
					int size = s / 2;
					conquer(x, y, size);
					conquer(x + size, y, size);
					conquer(x, y + size, size);
					conquer(x + size, y + size, size);
					return;
				}
			}
		}
		if (color == 1) b++;
		else w++;
	}
}