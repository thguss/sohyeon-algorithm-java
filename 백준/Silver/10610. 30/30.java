import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String N = getN();
		solve(N);
	}

	static void solve(String str) {
		if (!str.contains("0")) { // 0이 없으면 30의 배수가 될 수 없음
			System.out.println(-1);
			return;
		}

		int[] digits = new int[10]; // 0 ~ 9
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			int digit = Integer.parseInt(String.valueOf(str.charAt(i)));
			digits[digit]++;
			sum += digit;
		}

		if (sum % 3 != 0) { // 각 자릿수의 합이 3의 배수가 아니면 30의 배수가 될 수 없음
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			sb.append(String.valueOf(i).repeat(Math.max(0, digits[i])));
		}

		System.out.println(sb);
	}

	static String getN() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		return br.readLine();
	}

}