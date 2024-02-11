import java.lang.reflect.Member;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;

import org.w3c.dom.Node;

public class Main {

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> numberList = getNumberList();
		List<Integer> generatorList = getGeneratorList();

		for (int num : numberList) {
			if (!generatorList.contains(num)) {
				System.out.println(num);
			}
		}
	}

	private static List<Integer> getGeneratorList() {
		List<Integer> al = new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			int generator = i;
			String[] arr = String.valueOf(generator).split("");
			for (String str : arr) {
				generator += Integer.parseInt(str);
			}
			al.add(generator);
		}
		return al;
	}

	private static List<Integer> getNumberList() {
		List<Integer> al = new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			al.add(i);
		}
		return al;
	}
}