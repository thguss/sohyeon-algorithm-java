import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());

		String first = br.readLine();
		int[] word = getWord(first);
		int cnt = 0;

		for (int i = 1; i < N; i++) {
			String str = br.readLine();
			if (isSimilar(word, first, str)) cnt++;
		}

		System.out.println(cnt);
	}

	static boolean isSimilar(int[] word, String first, String str) {
		int[] check = word.clone();

		// 차이 1까지만 허용
		if (Math.abs(str.length() - first.length()) > 1) return false;

		int cnt = 0; // 같은 알파벳 개수

		for (int j = 0; j < str.length(); j++) {
			int idx = str.charAt(j) - 'A';
			if (check[idx] > 0) {
				check[idx]--;
				cnt++;
			}
		}

		// 기준 문자열 길이 = 현재 문자열 길이 + 1
		if (first.length() == str.length() + 1) {
			// 현재 문자열 길이가 작으니까, 모든 구성이 같아야 함
			if (cnt == str.length()) return true;
		}

		// 현재 문자열 길이 = 기존 문자열 길이 + 1
		if (first.length() + 1 == str.length()) {
			// 기존 문자열 길이가 작으니까, 모든 구성이 같아야 함
			if (cnt == first.length()) return true;
		}

		if (first.length() == str.length()) {
			// 모두 같거나
			if (cnt == str.length()) return true;

			// 다른 거 하나 허용하거나
			if (cnt == str.length() - 1) return true;
		}

		return false;
	}

	static int[] getWord(String str) {
		int[] word = new int['Z' - 'A' + 1];

		for (int i = 0; i < str.length(); i++) {
			word[str.charAt(i) - 'A']++;
		}

		return word;
	}

}