import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> result = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        bw.write(String.valueOf(result.size()) + "\n");
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)) + "\n");
        }

        bw.flush();
    }

    static void dfs(int start) {
        visited[start] = true;
        int next = arr[start];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            for (int i = next; i != start; i = arr[i]) {
                result.add(i);
            }
            result.add(start);
        }

        finished[start] = true;
    }

}