
import java.io.*;
import java.util.*;

public class Main {

	static String[] MBTI;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			if (N > 32) {
				System.out.println(0);
				continue;
			}
			
			MBTI = new String[N];
			for (int i = 0; i < N; i++) {
				MBTI[i] = st.nextToken();
			}

			System.out.println(getDistance());

		}

	}

	private static int getDistance() {
		int min = 12;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = 0;
					for (int m = 0; m < 4; m++) {
						temp += MBTI[i].charAt(m) != MBTI[j].charAt(m) ? 1 : 0;
						temp += MBTI[j].charAt(m) != MBTI[k].charAt(m) ? 1 : 0;
						temp += MBTI[i].charAt(m) != MBTI[k].charAt(m) ? 1 : 0;
					}
					min = Math.min(min, temp);
					if (min == 0) return 0;
				}
			}
		}
		return min;
	}
}