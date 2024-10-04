import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Unit {
        int sum = 0;
        int cnt = 0;
        List<int[]> al = new ArrayList<>();

        Unit() {
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static List<Unit> units;
    static boolean[][] visited;
    static int[][] arr;
    static int N, L, R;
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        L = Integer.valueOf(st.nextToken());
        R = Integer.valueOf(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        int step = 1;

        while (true) {
            units = new ArrayList<>();
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    bfs(i, j);
                }
            }

            if (units.size() == 0) break;

            for (Unit unit : units) {
                int avg = unit.sum / unit.cnt;

                for (int[] pos : unit.al) {
                    arr[pos[0]][pos[1]] = avg;
                }
            }

            step++;
        }

        bw.write(String.valueOf(step - 1));
        bw.flush();

    }

    static void bfs(int startI, int startJ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startI, startJ});
        visited[startI][startJ] = true;

        Unit unit = new Unit();
        unit.al.add(new int[] {startI, startJ});
        unit.sum = arr[startI][startJ];
        unit.cnt = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int abs = Math.abs(arr[nx][ny] - arr[x][y]);
                    if (L <= abs && abs <= R) {
                        visited[nx][ny] = true;
                        unit.al.add(new int[] {nx, ny});
                        unit.sum += arr[nx][ny];
                        unit.cnt++;
                        queue.add(new int[] {nx, ny});
                    }
                }
            }
        }

        if (unit.cnt > 1) units.add(unit);
    }

}