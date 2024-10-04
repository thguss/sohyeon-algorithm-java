import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static long[] solve(int N, long[] arr) {
        Stack<long[]> stack = new Stack<>();
        long[] result = new long[N];

        for (int i = 0; i < N; i++) {
            long height = arr[i];

            while (!stack.isEmpty() && stack.peek()[0] < height) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = stack.peek()[1];
            }

            stack.push(new long[] {height, i + 1});
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

        long[] res = solve(N, arr);

        for (long n : res) {
            bw.write(String.valueOf(n) + " ");
        }

        bw.flush();
    }

}