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
        int K = Integer.valueOf(st.nextToken());

        int[] arr = new int[2 * N];
        boolean[] robot = new boolean[N];
        int step = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
            if (arr[i] == 0) K--;
        }

        while(true) {
            // step1
            int last = arr[2 * N - 1];
            for (int i = 2 * N - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;
    
            // step2
            for (int i = N - 2; i >= 0; i--) {
                if (robot[i] && !robot[i + 1] && arr[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    arr[i + 1]--;
                    if (arr[i + 1] == 0) K--;
                }
            }
            robot[N - 1] = false;

            // step3
            if (arr[0] >= 1 && !robot[0]) {
                robot[0] = true;
                arr[0]--;
                if (arr[0] == 0) K--;
            }

            // step4
            if (K <= 0) break;
            step++;
        }
        
        bw.write(String.valueOf(step));
        bw.flush();
    }

}