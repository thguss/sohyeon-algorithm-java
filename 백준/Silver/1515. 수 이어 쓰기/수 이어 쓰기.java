import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String str = input();
		System.out.println(solve(str));
	}

	static int solve(String str) {
		int check = 0;
		int base = 0;

		while (base++ <= 30000) {
			String temp = String.valueOf(base);

			for (int i = 0; i < temp.length(); i++) {
				if (temp.charAt(i) == str.charAt(check)) check++;
				if (check == str.length()) return base;
			}
		}

		return base;
	}

	static String input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());
		return br.readLine();
	}

}