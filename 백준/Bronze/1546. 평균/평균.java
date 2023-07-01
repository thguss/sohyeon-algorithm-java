
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		float[] arr = new float[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		float max = Float.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			float num = Float.parseFloat(st.nextToken());
			arr[i] = num;
			max = Math.max(max, num);
		}
		float res = 0;
		for (float score : arr) {
			res += score / max * 100;
		}
		System.out.println(res / n);
	}
}