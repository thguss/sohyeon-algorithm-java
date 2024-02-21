import java.util.*;
import java.io.*;

public class Main {
	static class Alphabet implements Comparable<Alphabet> {
		long value = 0;
		boolean isFirst = false;

		@Override
		public int compareTo(Alphabet o) {
			return Long.compare(this.value, o.value);
		}
	}

	public static void main(String[] args) throws Exception { // 찬아 어렵다..
		Alphabet[] alphabets = getAlphabets();
		System.out.println(solve(alphabets));
	}

	static long solve(Alphabet[] alphabets) {
		long sum = 0;
		boolean[] isUsed = new boolean[10];

		for (int i = 0; i <= 9; i++) {
			sum += getValue(alphabets[i], isUsed);
		}

		return sum;
	}

	static long getValue(Alphabet alphabet, boolean[] isUsed) {
		if (alphabet.isFirst) {
			for (int i = 1; i <= 9; i++) {
				if (isUsed[i]) continue;
				isUsed[i] = true;
				return alphabet.value * (long)i; // 첫자리 수니까 1부터 가장 작은 수 대입
			}
		}

		for (int i = 0; i <= 9; i++) {
			if (isUsed[i]) continue;
			isUsed[i] = true;
			return alphabet.value * (long)i;
		}

		return 0;
	}

	static Alphabet[] getAlphabets() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(br.readLine());
		Alphabet[] alphabets = getAlphabets(10);

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int index = str.charAt(0) - 'A';
			alphabets[index].value += (long)Math.pow(10, (str.length() - 1)); // 10^(자릿수)
			alphabets[index].isFirst = true;
			for (int j = 1; j < str.length(); j++) {
				index = str.charAt(j) - 'A';
				alphabets[index].value += (long)Math.pow(10, (str.length() - 1 - j)); // 10^(자릿수)
			}
		}

		Arrays.sort(alphabets); // 오름차순

		return alphabets;
	}

	static Alphabet[] getAlphabets(int length) {
		Alphabet[] alphabets = new Alphabet[length];
		for (int i = 0; i < length; i++) {
			alphabets[i] = new Alphabet();
		}
		return alphabets;
	}

}