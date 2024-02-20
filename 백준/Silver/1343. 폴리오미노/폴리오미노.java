import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String board = getBoard();
		System.out.println(solve(board));
	}

	static String solve(String board) {
		String str = board.replaceAll("XXXX", "AAAA");
		String res = str.replaceAll("XX", "BB");
		return res.contains("X") ? "-1" : res;
	}

	static String getBoard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return br.readLine();
	}

}