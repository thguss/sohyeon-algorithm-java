
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i == 1) dp[i] = 1;
			else if (i == 2) dp[i] = 2;
			else dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}


		System.out.println(dp[N]);

	}
}