
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] floor = new int[15][15];
		for (int i = 1; i <= 14; i++) {
			floor[0][i] = i;
		}
		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				for (int f = 1; f <= j; f++) {
					floor[i][j] += floor[i - 1][f];
				}
			}
		}

		while (T-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(floor[k][n]);
		}
	}
}