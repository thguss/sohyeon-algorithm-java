import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.valueOf(br.readLine());
        Queue<Long> queue = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.add(Long.valueOf(st.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            queue.poll();
        }

        bw.write(String.valueOf(queue.poll()));
        bw.flush();
    }

}