import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();

        int totalA = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') totalA++;
        }

        int minB = Integer.MAX_VALUE;
        int currentB = 0;

        // 초기 구간
        for (int i = 0; i < totalA; i++) {
            if (str.charAt(i) == 'b') currentB++;
        }

        minB = Math.min(minB, currentB);

        // 슬라이딩 윈도우
        for (int i = 1; i < str.length(); i++) {
            int left = i - 1;
            if (str.charAt(left) == 'b') currentB--;

            int right = (i + totalA - 1) % str.length();
            if (str.charAt(right) == 'b') currentB++;

            minB = Math.min(minB, currentB);
        }

        bw.write(String.valueOf(minB));
        bw.flush();
    }

}