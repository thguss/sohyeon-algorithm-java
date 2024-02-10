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
		int res = 0;

		for (int i = 1; i <= N; i++) {
			if (isHansu(i)) {
				// System.out.println(i);
				res++;
			}
		}

		System.out.println(res);
	}

	private static boolean isHansu(int num) {
		String str = String.valueOf(num);

		if (str.length() == 1 || str.length() == 2) {
			return true;
		}

		String[] arr = str.split("");

		int distance = Integer.parseInt(arr[1]) - Integer.parseInt(arr[0]);

		for (int i = 2; i < arr.length; i++) {
			if (Integer.parseInt(arr[i]) - Integer.parseInt(arr[i - 1]) != distance) {
				return false;
			}
		}

		return true;
	}
}