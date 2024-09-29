import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(arr);
        
        int M = Integer.valueOf(br.readLine());

        int left = 0;
        int right = M;
        int max = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                sum += arr[i] <= mid ? arr[i] : mid;
            }

            if (sum <= M) {
                left = mid + 1;
                max = Math.max(max, arr[N - 1] <= mid ? arr[N - 1] : mid);
            } else {
                right = mid - 1;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }

}