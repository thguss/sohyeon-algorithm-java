import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		String str = getStr();
		int res = solve(str);
		System.out.println(res);
	}

	static int[] getDp() {
		int[] dp = new int[81];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 80; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp;
	}

	static int solve(String str) {
		int[] dp = getDp();
		int res = 1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'L') {
				int cnt = 0;
				while (i < str.length() && str.charAt(i) == 'L') {
					cnt++;
					i++;
				}
				// System.out.println(cnt);
				res *= dp[cnt];
			}
		}

		return res;
	}

	static String getStr() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		return str.replaceAll("long", "L");
	}
}