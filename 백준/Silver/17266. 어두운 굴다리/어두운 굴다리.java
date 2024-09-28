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
        int M = Integer.valueOf(br.readLine());

        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        bw.write(String.valueOf(solve(arr, N)));

        bw.flush();
    }

    private static int solve(int[] arr, int N) {
        int left = 1;
        int right = N;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (full(arr, N, mid)) {
                right = mid - 1;
                min = Math.min(min, mid);
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

    private static boolean full(int[] arr, int N, int height) {
        int point = 0;

        for (int idx : arr) {
            if (idx - height <= point) {
                point = idx + height;
            } else {
                return false;
            }
        }

        return point >= N;
    }

}