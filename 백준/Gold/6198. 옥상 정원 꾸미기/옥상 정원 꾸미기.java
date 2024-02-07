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
		Stack<Integer> stack = new Stack<>();
		long res = 0;

		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			popLowerBuildings(stack, h);
			res += stack.size(); // h 높이의 빌딩 옥상을 볼 수 있는 빌딩 개수
			stack.push(h);
		}

		System.out.println(res);
	}

	private static void popLowerBuildings(Stack<Integer> stack, int currentHeight) {
		// 현재 시점의 빌딩의 옥상을 보지 못하는 빌딩을 스택에서 빼낸다.
		while (!stack.isEmpty() && stack.peek() <= currentHeight) {
			stack.pop();
		}
	}
}