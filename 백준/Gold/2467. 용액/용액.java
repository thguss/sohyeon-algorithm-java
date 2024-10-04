import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] solve(long[] arr) {
        int left = 0;
        int right = arr.length - 1;
        long min = Long.MAX_VALUE;
        int[] result = new int[2];

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result = new int[] {left, right};
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                return new int[] {left, right};
            }
            
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.valueOf(st.nextToken());
        }

        int[] res = solve(arr);

        bw.write(String.valueOf(arr[res[0]]) + " " + String.valueOf(arr[res[1]]));
        bw.flush();
    }

}