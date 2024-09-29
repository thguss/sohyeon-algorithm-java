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
        long[] dist = new long[N - 1];
        long[] cost = new long[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.valueOf(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.valueOf(st.nextToken());
        }

        long sum = 0;
        long min = cost[0];

        for (int i = 0; i < N - 1; i++) {
            if (cost[i] < min) {
                min = cost[i];
            }

            sum += (min * dist[i]);
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}