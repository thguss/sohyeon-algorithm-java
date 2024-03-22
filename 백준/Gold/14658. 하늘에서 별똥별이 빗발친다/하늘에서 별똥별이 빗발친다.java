import java.util.*;
import java.io.*;

public class Main {
	static int N, M, L, K;

	public static void main(String[] args) throws Exception {
		List<int[]> stars = getStars();
		int max = Integer.MIN_VALUE;
		for (int[] star1 : stars) {
			for (int[] star2 : stars) {
				max = Math.max(max, countStars(stars, star1[0], star2[1]));
			}
		}
		System.out.println(K - max);
	}

	static int countStars(List<int[]> stars, int x, int y) {
		int cnt = 0;
		for (int[] star : stars) {
			int sx = star[0];
			int sy = star[1];
			if (x <= sx && sx <= x + L && y <= sy && sy <= y + L) cnt++;
		}
		return cnt;
	}

	static List<int[]> getStars() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		List<int[]> stars = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			stars.add(new int[] {x, y});
		}

		return stars;
	}

}