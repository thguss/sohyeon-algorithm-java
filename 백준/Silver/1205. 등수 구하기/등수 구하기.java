import java.util.*;
import java.io.*;

public class Main {

	static int N, P;
	static long score;

	public static void main(String[] args) throws IOException {
		long[] rankingList = getRankingList(); // 오름차순 정렬
		System.out.println(getRank(rankingList));
	}

	static int getRank(long[] rankingList) {
		if (P == N && rankingList[0] >= score) {
			return -1;
		}

		int rank = 1;

		for (int i = P - 1; i >= Math.max(0, P - N - 1); i--) {
			if (rankingList[i] > score) {
				rank++;
			} else {
				return rank;
			}
		}

		return rank;
	}

	static long[] getRankingList() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 리스트 내 점수 개수
		score = Long.parseLong(st.nextToken()); // 태수의 점수
		P = Integer.parseInt(st.nextToken()); // 랭킹 리스트 점수 개수

		long[] rankingList = new long[P];

		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				rankingList[i] = Long.parseLong(st.nextToken());
			}
		}

		Arrays.sort(rankingList);

		return rankingList;
	}

}