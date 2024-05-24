

import java.io.*;
import java.util.*;

public class Main {
	
	static long nodes[] = new long[2000000];
	
	public static void main(String srgs[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int firstLeaf = 1;
		while (firstLeaf < h) firstLeaf *= 2;

		for (int i = 1; i <= n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (i % 2 == 1) edit(1, x, firstLeaf);
			else edit(h - x + 1, h, firstLeaf);
			
		}
		
		long[] arr = new long[h + 1];
		for (int i = 1; i <= h; i++) {
			arr[i] = sum(i, firstLeaf);
		}
		
		long min = n + 1;
		int cnt = 0;
		for (int i = 1; i <= h; i++) {
			if (arr[i] < min) {
				min = arr[i];
				cnt = 1;
			}
			else if (arr[i] == min) cnt++;
		}

		 
		System.out.println(min + " " + cnt);
	}
	
	static void edit(int left, int right, int firstLeaf) {
		left = firstLeaf + left - 1;
		right = firstLeaf + right - 1;
		
		while (left <= right) {
			if (left % 2 == 1) nodes[left++]++;
			if (right % 2 == 0) nodes[right--]++;
			
			left /= 2;
			right /= 2;
		}
	}
	
	static long sum(int node, int firstLeaf) {
		node = firstLeaf + node - 1;
		
		long res = 0;
		
		while (node >= 1) {
			res += nodes[node];
			node /= 2;
		}
		
		return res;
	}
}
