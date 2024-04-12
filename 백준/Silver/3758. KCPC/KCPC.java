import java.util.*;
import java.io.*;

public class Main {

	static class Team implements Comparable<Team> {
		int id;
		int score;
		int count;
		int lastAt;

		Team(int id, int score, int count, int lastAt) {
			this.id = id;
			this.score = score;
			this.count = count;
			this.lastAt = lastAt;
		}

		@Override
		public int compareTo(Team o) {
			if (o.score == this.score) {
				if (this.count == o.count) {
					return this.lastAt - o.lastAt;
				}
				return this.count - o.count;
			}
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int a = 0; a < T; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 팀 개수
			int k = Integer.parseInt(st.nextToken()); // 문제 개수
			int t = Integer.parseInt(st.nextToken()); // 팀 ID
			int m = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수

			int[][] logs = new int[n + 1][k + 1];
			Team[] teams = new Team[n + 1];
			for (int i = 0; i <= n; i++) teams[i] = new Team(i, 0, 0, 0);

			for (int b = 0; b < m; b++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken()); // 팀 ID
				int j = Integer.parseInt(st.nextToken()); // 문제 번호
				int s = Integer.parseInt(st.nextToken()); // 획득 점수

				logs[i][j] = Math.max(logs[i][j], s);
				teams[i].count++;
				teams[i].lastAt = b;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= k; j++) {
					teams[i].score += logs[i][j];
				}
			}

			Arrays.sort(teams);

			sb.append(getRank(teams, t)).append("\n");
		}

		System.out.println(sb);

	}

	static int getRank(Team[] teams, int t) {
		for (int i = 0; i < teams.length; i++) {
			if (teams[i].id == t) return i + 1;
		}
		return -1;
	}

}