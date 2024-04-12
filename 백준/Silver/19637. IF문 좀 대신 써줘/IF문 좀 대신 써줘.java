import java.util.*;
import java.io.*;

public class Main {
	static int N, M;

	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 칭호 개수
		M = Integer.parseInt(st.nextToken()); // 캐릭터 수

		String[][] tag = new String[N][2];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tag[i][0] = st.nextToken(); // 칭호
			tag[i][1] = st.nextToken(); // 전투력
		}

		for (int i = 0; i < M; i++) {
			int hp = Integer.parseInt(br.readLine());
			sb.append(bs(tag, hp)).append("\n");
		}

		System.out.println(sb);

	}

	static String bs(String[][] tag, int hp) {
		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int power = Integer.parseInt(tag[mid][1]);

			if (power < hp) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return tag[left][0];
	}

}