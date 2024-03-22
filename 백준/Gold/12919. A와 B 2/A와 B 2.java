import java.util.*;
import java.io.*;

public class Main {
	static String S, T;
	static int res = 0;

	public static void main(String[] args) throws Exception {
		input();
		transfer(T);
		System.out.println(res);
	}

	static void transfer(String str) {
		if (res == 1) return;

		if (S.length() == str.length()) {
			if (S.equals(str)) res = 1;
			return;
		}

		if (str.charAt(str.length() - 1) == 'A') {
			transfer(str.substring(0, str.length() - 1));
		}

		if (str.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(str.substring(1));
			transfer(sb.reverse().toString());
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		S = br.readLine();
		T = br.readLine();
	}

}