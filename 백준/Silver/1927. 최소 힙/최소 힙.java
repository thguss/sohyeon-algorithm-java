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
        Queue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(a, b));

        for (int i = 0; i < N; i++) {
            long x = Long.valueOf(br.readLine());
            if (x == 0) {
                long res = pq.isEmpty() ? 0L : pq.poll();
                bw.write(String.valueOf(res) + "\n");
            } else {
                pq.add(x);
            }
        }

        bw.flush();
    }

}