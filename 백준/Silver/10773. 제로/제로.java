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

		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				continue;
			}
			stack.push(n);
		}

		System.out.println(getSum(stack));
	}

	private static int getSum(Stack<Integer> stack) {
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}