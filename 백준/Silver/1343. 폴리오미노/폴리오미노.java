import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String board = getBoard();
		StringBuilder sb = solve(board.split("\\."));

		if (sb.toString().equals("-1")) {
			System.out.println(sb);
		} else {
			sb.append(".".repeat(board.length() - sb.toString().length()));
			System.out.println(sb);
		}
	}

	static StringBuilder solve(String[] board) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < board.length; i++) {
			String str = board[i];

			if (str.length() % 2 != 0) {
				return new StringBuilder("-1");
			}

			if (str.length() % 4 == 0) {
				sb.append("AAAA".repeat(str.length() / 4));
			} else {
				sb.append("AAAA".repeat(str.length() / 4));
				sb.append("BB".repeat((str.length() % 4) / 2));
			}

			if (i != board.length - 1) {
				sb.append(".");
			}
		}

		return sb;
	}

	static String getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return br.readLine();
	}

}