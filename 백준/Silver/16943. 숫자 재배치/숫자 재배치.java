import java.util.*;
import java.io.*;

public class Main {
	static String A;
	static int B;
	static int res = -1;

	public static void main(String[] args) throws Exception {
		input();
		comb(new char[A.length()], new boolean[A.length()], 0);
		System.out.println(res);
	}

	static void comb(char[] arr, boolean[] visited, int index) {
		if (index == A.length()) {
			int num = arrToInt(arr);
			if (num < B) {
				res = Math.max(res, num);
			}
			return;
		}

		for (int i = 0; i < A.length(); i++) {
			if (index == 0 && A.charAt(i) == '0') continue;
			if (visited[i]) continue;
			arr[index] = A.charAt(i);
			visited[i] = true;
			comb(arr, visited, index + 1);
			visited[i] = false;
		}
	}

	static int arrToInt(char[] arr) {
		StringBuilder sb = new StringBuilder();
		for (char i : arr) {
			sb.append(i);
		}
		return Integer.parseInt(sb.toString());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());
	}
}