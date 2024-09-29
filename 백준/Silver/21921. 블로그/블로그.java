import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int X = Integer.valueOf(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int[] visit = new int[N];
        visit[0] = arr[0];
        for (int i = 1; i < X; i++) {
            visit[i] = visit[i - 1] + arr[i];
        }

        int max = visit[X - 1];
        int count = 1;

        for (int i = X; i < N; i++) {
            visit[i] = visit[i - 1] + arr[i] - arr[i - X];
            if (max < visit[i]) {
                max = visit[i];
                count = 1;
            } else if (max == visit[i]) {
                count++;
            }
        }

        if (max != 0) {
            bw.write(String.valueOf(max) + "\n" + String.valueOf(count));
        } else {
            bw.write("SAD");
        }

        bw.flush();
    }

}