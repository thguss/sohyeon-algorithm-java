
import java.io.*;
import java.util.*;

public class Main {

	static final int P = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine()); // 주사위 개수

		long N = 1, S = 0;

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // n면체
			int s = Integer.parseInt(st.nextToken()); // 각 면에 적힌 모든 숫자의 합
			// 통분 계산, mod
			S = (s * N + S * n) % P;
			N = (N * n) % P;
		}

		if (S % N != 0) { // 기약 분수
			System.out.println((search(N, P - 2) * S) % P);
		} else {
			System.out.println(S / N);
		}

	}

	private static long search(long N, int index) {
		if (index == 1) {
			return N;
		}
		long temp = search(N, index / 2);
		return index % 2 == 1 ? temp * temp % P * N % P : temp * temp % P;
	}

}