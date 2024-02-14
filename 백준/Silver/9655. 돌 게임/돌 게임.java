import java.lang.reflect.Member;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[1001]; // N < 1000
		dp[1] = 1; // 1turn
		dp[2] = 2; // 2turn
		dp[3] = 1; // 3turn

		for (int i = 4; i <= N; i++) {
			dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1; // 1개 또는 3개 돌을 가져간다.
		}

		System.out.println(getWinner(dp[N]));

	}

	private static String getWinner(int turnCount) {
		return (turnCount % 2 != 0) ? "SK" : "CY"; // 홀수 번 돌면 상근이, 짝수 번 돌면 창영이 승리
	}
}