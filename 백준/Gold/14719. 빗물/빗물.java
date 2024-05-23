import java.util.*;
import java.io.*;

public class Main {

	static int H, W;

	public static void main(String[] args) throws Exception {
		int[][] board = getBoard();

		// for (int[] arr : board) {
		// 	System.out.println(Arrays.toString(arr));
		// }

		int sum = 0;

		for (int i = 0; i < H; i++) {
			boolean isLeft = false;
			int cnt = 0;
			for (int j = 0; j < W; j++) {
				if (board[i][j] == 0 && isLeft) {
					cnt++;
				} else if (board[i][j] == 1 && isLeft) {
					sum += cnt;
					cnt = 0;
				} else if (board[i][j] == 1 && !isLeft) {
					isLeft = true;
				}
			}
		}

		System.out.println(sum);

	}

	static int[][] getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		int[][] board = new int[H][W];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < W; i++) {
			int height = Integer.parseInt(st.nextToken());
			for (int j = 0; j < height; j++) {
				board[H - 1 - j][i] = 1;
			}
		}

		return board;
	}

}