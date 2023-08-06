
import java.io.*;
import java.util.*;

public class Main {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		long[] dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i < 101; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}

		// System.out.println(Arrays.toString(dp));

	}


}