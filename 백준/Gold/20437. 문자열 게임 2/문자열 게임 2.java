import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			String str = br.readLine();
			int K = Integer.parseInt(br.readLine());
			sb.append(getRes(str, K)).append("\n");
		}

		System.out.println(sb);
	}

	static String getRes(String str, int K) {
		if (K == 1) return "1 1";

		int[] alpha = new int['z' - 'a' + 1];

		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 'a']++;
		}

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < str.length(); i++) {
			if (alpha[str.charAt(i) - 'a'] < K) continue;

			int count = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) count++;

				if (count == K) {
					min = Math.min(min, j - i + 1);
					max = Math.max(max, j - i + 1);
					break;
				}
			}
		}

		if (max == 0 || min == Integer.MAX_VALUE) return "-1";
		else return min + " " + max;
	}

}