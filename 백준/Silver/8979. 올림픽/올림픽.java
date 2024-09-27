import java.util.*;
import java.io.*;

public class Main {

	static class Nation implements Comparable<Nation> {
		int num;
		int goldCnt;
		int silverCnt;
		int bronzeCnt;
		int rank;

		Nation(int num, int goldCnt, int silverCnt, int bronzeCnt) {
			this.num = num;
			this.goldCnt = goldCnt;
			this.silverCnt = silverCnt;
			this.bronzeCnt = bronzeCnt;
		}

		int getScore() {
			return this.goldCnt * 3 + this.silverCnt * 2 + this.bronzeCnt;
		}

		@Override
		public int compareTo(Nation o) {
			if (this.goldCnt == o.goldCnt) {
				if (this.silverCnt == o.silverCnt) {
					return o.bronzeCnt - this.bronzeCnt;
				}
				return o.silverCnt - this.silverCnt;
			}
			return o.goldCnt - this.goldCnt;
		}
	}

	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 국가 수
		int K = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가 번호

		List<Nation> nations = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int goldCnt = Integer.parseInt(st.nextToken());
			int silverCnt = Integer.parseInt(st.nextToken());
			int bronzeCnt = Integer.parseInt(st.nextToken());

			nations.add(new Nation(num, goldCnt, silverCnt, bronzeCnt));
		}

		Collections.sort(nations);
		solve(N, K, nations);
	}

	static void solve(int N, int K, List<Nation> nations) {
		int endPoint = 0;
		nations.get(0).rank = 1;

		for (int i = 1; i < N; i++) {
			Nation nation = nations.get(i);
			Nation preNation = nations.get(i - 1);

			if (nation.num == K) {
				endPoint = i;
			}

			if (nation.goldCnt == preNation.goldCnt && nation.silverCnt == preNation.silverCnt && nation.bronzeCnt == preNation.bronzeCnt) {
				nation.rank = preNation.rank;
			} else {
				nation.rank = i + 1;
			}
		}

		System.out.println(nations.get(endPoint).rank);
	}
}