
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		for (int i = 0; i <= N; i++) {
			if (separate(i) == N) {
				res = i;
				break;
			}
		}
		System.out.println(res);
	}

	private static int separate(int num) {
		int number = num;
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		sum += num;
		return sum;
	}
}