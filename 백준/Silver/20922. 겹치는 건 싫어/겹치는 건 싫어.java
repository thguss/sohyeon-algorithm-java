import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String[] args) throws Exception {
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int start = 0;
		int end = 0;
		int[] cnt = new int[100001]; // 정수 개수

		while (end < N) {
		    while (end < N && cnt[arr[end]] + 1 <= K) {
		        cnt[arr[end]]++;
		        end++;
		    }
		    
		    int len = end - start;
		    ans = Math.max(ans, len);
		    cnt[arr[start]]--;
		    start++;
		}

		bw.write(Integer.toString(ans));
		bw.flush();
	}
}