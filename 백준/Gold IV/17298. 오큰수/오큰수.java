import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static int N;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		// st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());
		Stack<Integer> numbers = getNumbers();
		Stack<Integer> result = getResult(numbers);
		StringBuilder sb = new StringBuilder();

		while(!result.isEmpty()) {
			sb.append(result.pop()).append(" ");
		}

		System.out.println(sb);
	}

	private static Stack<Integer> getResult(Stack<Integer> numbers) {
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> result = new Stack<>();

		while(!numbers.isEmpty()) {
			int num = numbers.pop();

			while (!stack.isEmpty() && stack.peek() <= num) {
				stack.pop();
			}

			result.push(stack.isEmpty() ? -1 : stack.peek());
			stack.push(num);
		}

		return result;
	}

	private static Stack<Integer> getNumbers() throws IOException {
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			stack.push(Integer.parseInt(st.nextToken()));
		}

		return stack;
	}
}