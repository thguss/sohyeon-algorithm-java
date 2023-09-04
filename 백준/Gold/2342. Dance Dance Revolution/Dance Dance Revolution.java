import java.util.*;
import java.io.*;

public class Main {

	// 중앙 0 | 위 1 | 왼 2 | 아래 3 | 오른 4
	// 중앙에서 이동 +2 | 그 외 인접하게 이동 +3 | 반대편으로 +4 | 같은 지점 +1

	static ArrayList<Integer> al;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		al = new ArrayList<>();

		while (true) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				break;
			}
			al.add(num);
		}

		dp = new int[5][5][al.size()];
		for (int[][] arr1 : dp) {
			for (int[] arr2 : arr1) {
				Arrays.fill(arr2, -1);
			}
		}

		System.out.println(solve(0, 0, 0));

	}

	private static int energy(int pos, int des) {
		int num = Math.abs(pos - des);
		if (pos == 0) return 2;
		if (num == 0) return 1;
		else if (num == 1 || num == 3) return 3;
		else return 4;
	}

	private static int solve(int left, int right, int cnt) {
		if (cnt == al.size()) return 0;
		if (dp[left][right][cnt] != -1) return dp[left][right][cnt];

		return dp[left][right][cnt] = Math.min(
				solve(al.get(cnt), right, cnt + 1) + energy(left, al.get(cnt)),
				solve(left, al.get(cnt), cnt + 1) + energy(right, al.get(cnt)));
	}
}
