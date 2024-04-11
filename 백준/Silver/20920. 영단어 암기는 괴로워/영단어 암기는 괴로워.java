import java.util.*;
import java.io.*;

public class Main {

	static class Word implements Comparable<Word> {
		String str;
		int count;

		Word(String str, int count) {
			this.str = str;
			this.count = count;
		}

		@Override
		public int compareTo(Word o) {
			if (this.count == o.count) {
				if (this.str.length() == o.str.length()) {
					return this.str.compareTo(o.str);
				}
				return o.str.length() - this.str.length();
			}
			return o.count - this.count;
		}
	}

	static int N, M;

	public static void main(String[] args) throws Exception {
		Queue<Word> pq = getQueue();
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll().str).append("\n");
		}
		System.out.println(sb);
	}

	static Queue<Word> getQueue() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.length() < M) continue;
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		Queue<Word> pq = new PriorityQueue<>();
		for (String key : map.keySet()) {
			pq.add(new Word(key, map.get(key)));
		}

		return pq;
	}

}