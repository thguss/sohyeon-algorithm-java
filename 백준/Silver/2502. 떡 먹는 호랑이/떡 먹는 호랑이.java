import java.util.*;
import java.io.*;

public class Main {
	static int D, K;
	static int A, B;

	public static void main(String[] args) throws Exception {
		input();
		for (int i = 1; i <= K / 2; i++) {
			boolean isEnd = solve(K - i, i);
			if (isEnd) {
				System.out.println(A);
				System.out.println(B);
				break;
			}
		}
	}

	static boolean solve(int K1, int K2) {
		// System.out.println("===");
		// System.out.println(K1 + " " + K2);
		/**
		 * K1 : 어제 개수 (D-1)
		 * K2 : 그저께 개수 (D-2)
		 * K1 > K2
		 */

		int day = D - 2;
		int k1 = K1;
		int k2 = K2;

		while (day > 1) {
			day--;
			int next = k1 - k2;
			if (next > k2) return false;
			k1 = k2;
			k2 = next;
			// System.out.println(k1 + " " + k2);
		}

		// System.out.println(k1 + " " + k2);
		A = k2;
		B = k1;

		return true;
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}
}