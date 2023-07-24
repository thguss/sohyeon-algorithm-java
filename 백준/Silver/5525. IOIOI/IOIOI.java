
import java.io.*;
import java.util.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split("");

		int res = 0;
		int cnt = 0;

		for (int i = 1; i < M - 1; i++) {
			if (arr[i - 1].equals("I") && arr[i].equals("O") && arr[i + 1].equals("I")) {
				cnt++;
				if (cnt == N) {
					cnt--;
					res++;
				}
				i++;
			} else {
				cnt = 0;
			}
		}

		System.out.println(res);

	}

}