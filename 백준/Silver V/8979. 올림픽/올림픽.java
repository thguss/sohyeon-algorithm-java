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
			return o.getScore() - this.getScore();
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
		System.out.println(getRank(N, K, nations));
	}

	static int getRank(int N, int K, List<Nation> nations) {
		if (N == 1) {
			return 1;
		}

		int rank = 1;
		nations.get(0).rank = 1;

		for (int i = 1; i < N; i++) {
			rank++;
			Nation nation = nations.get(i);
			Nation preNation = nations.get(i - 1);
			nations.get(i).rank = (nation.getScore() == preNation.getScore()) ? preNation.rank : rank;

			if (nation.num == K) {
				return nation.rank;
			}
		}

		return -1;
	}
}