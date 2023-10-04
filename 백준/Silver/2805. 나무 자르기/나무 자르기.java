
import java.util.*;
import java.io.*;

public class Main {
	
	static int res = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		getTree(n, m, arr);
		
		System.out.println(res);
		
	}
	
	static void getTree(int n, long m, int[] arr) {
		int start = 0;
		int end = arr[n - 1];
		
		while (start <= end) {
			int mid = (start + end) / 2;
			long treeNum = getTreeNum(n, m, arr, mid);
			
			if (m == treeNum) {
				res = mid;
				return;
			}
			else if (treeNum > m) {
				res = mid;
				start = mid + 1;
			}
			else { // treeNum < m
				end = mid - 1;
			}
		}
	}
	
	static long getTreeNum(int n, long m, int[] arr, int height) {
		long cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (cnt > m) return cnt;
			if (arr[i] > height) cnt += (arr[i] - height);
		}
		
		return cnt;
	}

}
