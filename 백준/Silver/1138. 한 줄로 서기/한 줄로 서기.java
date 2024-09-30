import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        List<Integer> al = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            int cnt = arr[i];

            if (cnt < al.size()) {
                al.add(cnt, i + 1);
            } else {
                al.add(i + 1);
            }
        }

        for (int i : al) {
            bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
    }

}