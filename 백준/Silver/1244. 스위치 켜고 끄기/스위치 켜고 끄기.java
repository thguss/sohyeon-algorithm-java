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
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int K = Integer.valueOf(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.valueOf(st.nextToken());
            int num = Integer.valueOf(st.nextToken());

            if (gender == 1) {
                boy(arr, num);
            } else if (gender == 2) {
                girl(arr, num);
            }

            //System.out.println(Arrays.toString(arr));
        }

        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(arr[i]) + " ");
            if (i % 20 == 0) bw.write("\n");
        }

        bw.flush();
    }

    private static void boy(int[] arr, int num) {
        for (int i = num; i < arr.length; i += num) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }

    private static void girl(int[] arr, int num) {
        int left = num - 1;
        int right = num + 1;

        while (0 < left && left < arr.length && 0 < right && right < arr.length) {
            if (arr[left] != arr[right]) break;

            arr[left] = arr[left] == 0 ? 1 : 0;
            arr[right] = arr[left];

            left--;
            right++;
        }

        arr[num] = arr[num] == 0 ? 1 : 0;
    }


}