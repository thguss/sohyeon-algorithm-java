
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			map.put(name, 1);
		}

		ArrayList<String> res = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (map.containsKey(name)) {
				res.add(name);
			}
		}

		Collections.sort(res);

		StringBuilder sb = new StringBuilder();
		sb.append(res.size()).append("\n");

		for (String name : res) {
			sb.append(name).append("\n");
		}

		System.out.println(sb);
	}
}