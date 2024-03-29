
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] visited = new int[101];
	static int[] board = new int[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String password = st.nextToken();
			map.put(site, password);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(map.get(site)).append("\n");
		}

		System.out.println(sb);

	}
}