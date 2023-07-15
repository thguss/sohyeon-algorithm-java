
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		System.out.println(Math.round((double)sum / (double)N));

		Arrays.sort(arr);
		System.out.println(arr[arr.length / 2]);

		// 최빈값
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int max = 0;
		for (int value : map.values()) {
			max = Math.max(max, value);
		}
		ArrayList<Integer> al = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == max) {
				al.add(key);
			}
		}
		Collections.sort(al);
		if (al.size() < 2) {
			System.out.println(al.get(0));
		} else {
			System.out.println(al.get(1));
		}

		// 범위
		System.out.println(arr[arr.length - 1] - arr[0]);
	}
}