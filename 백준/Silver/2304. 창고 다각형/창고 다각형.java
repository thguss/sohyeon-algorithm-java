import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[1001];
        int maxX = 0;
        int maxY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            arr[x] = y;
            if (y > maxY) {
                maxX = x;
                maxY = y;
            }
        }

        int sum = maxY;

        Deque<Node> queue = new LinkedList<>();
        for (int i = 1; i <= maxX; i++) {
            if (arr[i] == 0) continue;

            if (queue.isEmpty()) {
                queue.addFirst(new Node(i, arr[i]));
            } else if (queue.peekFirst().y <= arr[i]) {
                int dx = i - queue.peekFirst().x;
                int dy = queue.peekFirst().y;
                sum += dx * dy;
                queue.addFirst(new Node(i, arr[i]));
            }
        }

        queue = new LinkedList<>();
        for (int i = 1000; i >= maxX; i--) {
            if (arr[i] == 0) continue;

            if (queue.isEmpty()) {
                queue.addFirst(new Node(i, arr[i]));
            } else if (queue.peekFirst().y <= arr[i]) {
                int dx = queue.peekFirst().x - i;
                int dy = queue.peekFirst().y;
                sum += dx * dy;
                queue.addFirst(new Node(i, arr[i]));
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}