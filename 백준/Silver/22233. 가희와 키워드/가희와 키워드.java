import java.util.*;
import java.io.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 메모장 키워드 개수
		M = Integer.parseInt(st.nextToken()); // 블로그 키워드 개수

		Set<String> memoKeywords = new HashSet<>();

		for (int i = 0; i < N; i++) {
			memoKeywords.add(br.readLine());
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String[] arr = br.readLine().split(",");

			for (String str : arr) {
				memoKeywords.remove(str);
			}

			sb.append(memoKeywords.size()).append("\n");
		}

		System.out.println(sb);
	}

}