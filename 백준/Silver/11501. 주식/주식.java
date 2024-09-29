import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(br.readLine());

        while(T-- > 0) {
            int N = Integer.valueOf(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.valueOf(st.nextToken());
            }
            bw.write(String.valueOf(solve(arr)) + "\n");
        }

        bw.flush();
    }

    private static long solve(int[] arr) {
        long sum = 0;
        int max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                sum += (max - arr[i]);
            }
        }
        
        return sum;
    }

}