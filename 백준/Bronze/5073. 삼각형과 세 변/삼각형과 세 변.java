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

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			System.out.println(getDefinition(new int[] {a, b, c}));
		}

	}

	private static String getDefinition(int[] arr) {
		Arrays.sort(arr);
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];

		if (c >= (a + b)) {
			return "Invalid";
		}

		if (a == b && b == c) {
			return "Equilateral";
		} else if (a != b && b != c && c != a) {
			return "Scalene";
		} else {
			return "Isosceles";
		}
	}
}