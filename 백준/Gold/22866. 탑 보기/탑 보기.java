import java.util.*;
import java.io.*;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		int[] buildings = getBuildings();
		int[] counts = new int[N + 1];
		int[] nears = new int[N + 1];
		Arrays.fill(nears, Integer.MAX_VALUE);
		Stack<Integer> stack;

		// 왼쪽 빌딩
		stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
				stack.pop();
			}
			counts[i] = stack.size();
			if (counts[i] > 0) nears[i] = stack.peek();
			stack.push(i);
		}

		// 오른쪽 빌딩
		stack = new Stack<>();
		for (int i = N; i >= 1; i--) {
			while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
				stack.pop();
			}
			if (!stack.isEmpty() && Math.abs(i - nears[i]) > Math.abs(stack.peek() - i)) nears[i] = stack.peek();
			counts[i] += stack.size();
			stack.push(i);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (counts[i] > 0) {
				sb.append(counts[i]).append(" ").append(nears[i]).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}

	static int[] getBuildings() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		return arr;
	}

}