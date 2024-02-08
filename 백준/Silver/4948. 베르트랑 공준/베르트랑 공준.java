import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		boolean isEnd = false;
		arr = new int[123457];

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			System.out.println(getPrimeCount(n));
		}
	}

	private static int getPrimeCount(int n) {
		if (arr[n] != 0) {
			return arr[n];
		}

		int count = 0;

		for (int i = n + 1; i <= 2 * n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}

		return arr[n] = count;
	}

	private static boolean isPrime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}

		if (num == 2) {
			return true;
		}

		for (int i = 2; i < Math.sqrt(num) + 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}