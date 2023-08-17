
import java.io.*;
import java.util.*;

public class Main {
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		String bomb = br.readLine();

		Stack<Character> stack = bombStr(bomb);

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character ch : stack) {
				sb.append(ch);
			}
			System.out.println(sb);
		}
	}

	private static Stack<Character> bombStr(String bomb) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) { // 스택으로 push
			int count = 0;
			stack.push(str.charAt(i));

			if (stack.size() >= bomb.length()) { // 스택 크기가 폭발 문자열 크기 이상이 되면 문자열 검사
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) {
						count++; // bomb[j] == stack[stack.len - bomb.len + j]이면 count
					}
				}
				if (count == bomb.length()) { // 폭발 문자열과 일치하는 부분 문자열이 있으면 그만큼 스택에서 pop
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		return stack;
	}

}