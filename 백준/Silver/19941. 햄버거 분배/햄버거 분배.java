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
        char[] arr = new char[N];
        int cnt = 0;

        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                int left = Math.max(0, i - K);
                boolean eat = false;

                for (int j = left; j < i; j++) {
                    if (arr[j] == 'H') {
                        eat = true;
                        arr[j] = 'X';
                        cnt++;
                        break;
                    }
                }

                if (!eat) {
                    int right = Math.min(N - 1, i + K);

                    for (int j = i + 1; j <= right; j++) {
                        if (arr[j] == 'H') {
                            arr[j] = 'X';
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

}