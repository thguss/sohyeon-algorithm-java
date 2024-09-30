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

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        boolean[] visited = new boolean[200002];
        visited[N] = true;
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == K) {
                min = Math.min(min, cur[1]);
                continue;
            }

            int next = cur[0] + 1;
            if (0 <= next && next < 100002 && !visited[next]) {
                visited[next] = true;
                queue.add(new int[] {next, cur[1] + 1});
            }

            next = cur[0] - 1;
            if (0 <= next && next < 100002 && !visited[next]) {
                visited[next] = true;
                queue.add(new int[] {next, cur[1] + 1});
            }

            next = cur[0] * 2;
            if (0 <= next && next < 100002 && !visited[next]) {
                visited[next] = true;
                queue.add(new int[] {next, cur[1] + 1});
            }
        }
        
        bw.write(String.valueOf(min != Integer.MAX_VALUE ? min : -1));
        bw.flush();
    }

}