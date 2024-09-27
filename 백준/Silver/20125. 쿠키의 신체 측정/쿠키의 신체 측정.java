import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Character[][] arr;
    static int N;
    
    public static void main(String[] args) throws Exception {
        // StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(br.readLine());
        arr = new Character[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int[] head = getHead();
        int[] heart = new int[] {head[0] + 1, head[1]};
        bw.write(String.valueOf(heart[0] + 1) + " " + String.valueOf(heart[1] + 1) + "\n");

        // 왼쪽 팔
        int leftArmSize = getSize(heart[0], heart[1] - 1, 0, -1);
        bw.write(String.valueOf(leftArmSize) + " ");

        // 오른쪽 팔
        int rightArmSize = getSize(heart[0], heart[1] + 1, 0, 1);
        bw.write(String.valueOf(rightArmSize) + " ");

        // 허리
        int waistSize = getSize(heart[0] + 1, heart[1], 1, 0);
        bw.write(String.valueOf(waistSize) + " ");

        int[] point = new int[] {heart[0] + waistSize, heart[1]};

        // 왼쪽 다리
        int leftLegSize = getSize(point[0] + 1, point[1] - 1, 1, 0);
        bw.write(String.valueOf(leftLegSize) + " ");

        // 오른쪽 다리
        int rightLegSize = getSize(point[0] + 1, point[1] + 1, 1, 0);
        bw.write(String.valueOf(rightLegSize));
        
        bw.flush();
    }

    private static int getSize(int i, int j, int dx, int dy) {
        int size = 0;

        while (0 <= i && i < N && 0 <= j && j < N) {
            if (arr[i][j] != '*') break;

            size++;
            i += dx;
            j += dy;
        }

        return size;
    }

    private static int[] getHead() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*') return new int[] {i, j};
            }
        }

        return null;
    }

}