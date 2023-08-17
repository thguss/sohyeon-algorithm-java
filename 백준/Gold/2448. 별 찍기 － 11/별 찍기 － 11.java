
import java.io.*;
import java.util.*;

public class Main {

	static char[][] stars;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		stars = new char[N][N * 2 - 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' ');
		}

		printStar(0, N - 1, N);

		StringBuilder sb = new StringBuilder();
		for (char[] star : stars) {
			for (char c : star) {
				sb.append(c);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void printStar(int r, int c, int N) {
		if (N == 3) { // k == 0
			stars[r][c] = '*';
			stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
			stars[r + 2][c + 2] = stars[r + 2][c + 1] = stars[r + 2][c] = stars[r + 2][c - 1] = stars[r + 2][c - 2] = '*';
		} else { // k > 0
			int div = N / 2;
			printStar(r, c, div); // 위쪽
			printStar(r + div, c - div, div); // 아래 왼쪽
			printStar(r + div, c + div, div); // 아래 오른쪽
		}
	}

}