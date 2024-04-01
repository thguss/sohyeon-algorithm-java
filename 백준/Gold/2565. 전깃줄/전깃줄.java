import java.util.*;
import java.io.*;

public class Main {
	static class Link implements Comparable<Link> {
		int line1;
		int line2;

		Link(int line1, int line2) {
			this.line1 = line1;
			this.line2 = line2;
		}

		@Override
		public int compareTo(Link o) {
			if (this.line1 == o.line1) {
				return this.line2 - o.line2;
			}
			return this.line1 - o.line1;
		}
	}

	static int N;

	public static void main(String[] args) throws Exception {
		List<Link> links = getLinks();
		System.out.println(N - dp(links));
	}

	static int dp(List<Link> links) { // 전깃줄 가장 많이 연결하기
		// for (Link link : links) {
		// 	System.out.println(link.line1 + " " + link.line2);
		// }

		int[] dp = new int[links.size()];
		int max = 0;

		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (links.get(i).line2 >= links.get(j).line2) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	static List<Link> getLinks() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		List<Link> links = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int line1 = Integer.parseInt(st.nextToken());
			int line2 = Integer.parseInt(st.nextToken());
			links.add(new Link(line1, line2));
		}

		Collections.sort(links);

		return links;
	}

}