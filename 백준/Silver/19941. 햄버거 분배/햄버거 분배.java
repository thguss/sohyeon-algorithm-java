import java.util.*;
import java.io.*;

public class Main {

	static int N, K;

	public static void main(String[] args) throws Exception {
		char[] table = input();
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			if (table[i] == 'P') {
				int left = Math.max(0, i - K);
				boolean isEat = false;

				for (int j = left; j < i; j++) {
					if (table[j] == 'H') {
						isEat = true;
						table[j] = 'X';
						cnt++;
						break;
					}
				}

				if (!isEat) {
					int right = Math.min(N - 1, i + K);

					for (int j = i + 1; j <= right; j++) {
						if (table[j] == 'H') {
							table[j] = 'X';
							cnt++;
							break;
						}
					}
				}
			}
		}

		System.out.println(cnt);
		// System.out.println(Arrays.toString(table));
	}

	static char[] input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		return br.readLine().toCharArray();
	}

}