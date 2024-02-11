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
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		System.out.println(getLCM(A, B));
	}

	private static long getLCM(long num1, long num2) {
		if (num2 > num1) {
			long temp = num1;
			num1 = num2;
			num2 = temp;
		}
		long gcd = getGCD(num1, num2);
		return getLCM((num1 * num2) / gcd, num1, num2);
	}

	private static long getLCM(long lcm, long num1, long num2) {
		long gcd = getGCD(lcm, num1);
		lcm = (lcm * num1) / gcd;

		gcd = getGCD(lcm, num2);
		lcm = (lcm * num2) / gcd;

		return lcm;
	}

	private static long getGCD(long num1, long num2) {
		if (num2 > num1) {
			long temp = num1;
			num1 = num2;
			num2 = temp;
		}

		if (num1 % num2 == 0) {
			return num2;
		}

		return getGCD(num2, num1 % num2);
	}
}