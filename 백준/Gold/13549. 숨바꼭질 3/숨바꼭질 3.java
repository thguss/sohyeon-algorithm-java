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

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]] = true;

            //System.out.println(Arrays.toString(cur));

            if (cur[0] == K) {
                min = Math.min(min, cur[1]);
            }

            int x = cur[0] * 2;
            if (x <= 100000 && !visited[x]) {
                queue.add(new int[] {x, cur[1]});
            }

            x = cur[0] + 1;
            if (x <= 100000 && !visited[x]) {
                queue.add(new int[] {x, cur[1] + 1});
            }

            x = cur[0] - 1;
            if (0 <= x && !visited[x]) {
                queue.add(new int[] {x, cur[1] + 1});
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }

}