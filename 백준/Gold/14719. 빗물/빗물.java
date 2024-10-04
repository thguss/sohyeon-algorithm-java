import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int solve(int[][] board, int H, int W) {
        int sum = 0;

        // for (int i = 0; i < H; i++) {
        //     System.out.println(Arrays.toString(board[i]));
        // }

        for (int i = 0; i < H; i++) {
            boolean guard = false;
            int cnt = 0;

            for (int j = 0; j < W; j++) {
                if (board[i][j] == 1 && guard) {
                    sum += cnt;
                    cnt = 0;
                } else if (board[i][j] == 1 && !guard) {
                    guard = true;
                } else if (board[i][j] == 0 && guard) {
                    cnt++;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.valueOf(st.nextToken());
        int W = Integer.valueOf(st.nextToken());
        int[][] board = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < W; j++) {
            int height = Integer.valueOf(st.nextToken());
            for (int i = 0; i < height; i++) {
                board[i][j] = 1;
            }
        }

        int sum = solve(board, H, W);

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}