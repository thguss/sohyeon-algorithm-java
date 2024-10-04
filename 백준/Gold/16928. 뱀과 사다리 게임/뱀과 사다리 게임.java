import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int solve(Map<Integer, Integer> stairs, Map<Integer, Integer> slidings) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});
        boolean[] visited = new boolean[101];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int cnt = cur[1];

            //visited[num] = true;

            if (num == 100) {
                return cnt;
            }

            for (int i = 1; i <= 6; i++) {
                int next = num + i;

                if (next > 100) continue;

                while (stairs.containsKey(next) || slidings.containsKey(next)) {
                    if (stairs.containsKey(next)) {
                        next = stairs.get(next);
                    }
                    
                    if (slidings.containsKey(next)) {
                        next = slidings.get(next);
                    }
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, cnt + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        Map<Integer, Integer> stairs = new HashMap<>();
        Map<Integer, Integer> slidings = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            stairs.put(u, v);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            slidings.put(u, v);
        }

        int res = solve(stairs, slidings);
        
        bw.write(String.valueOf(res));
        bw.flush();
    }

}