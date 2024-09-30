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
        String str = br.readLine();
        int min = Integer.MAX_VALUE;

        // 왼쪽으로 빨간 공 모으기
        int cnt = 0;
        boolean isMove = false;
        for (int i = 0; i < N; i++) {
            if (isMove && str.charAt(i) == 'R') {
                cnt++;
                continue;
            }
            if (str.charAt(i) == 'B') isMove = true;
        }

        min = Math.min(min, cnt);

        // 오른쪽으로 빨간 공 모으기
        cnt = 0;
        isMove = false;
        for (int i = N - 1; i >= 0; i--) {
            if (isMove && str.charAt(i) == 'R') {
                cnt++;
                continue;
            }
            if (str.charAt(i) == 'B') isMove = true;
        }

        min = Math.min(min, cnt);

        // 왼쪽으로 파란 공 모으기
        cnt = 0;
        isMove = false;
        for (int i = 0; i < N; i++) {
            if (isMove && str.charAt(i) == 'B') {
                cnt++;
                continue;
            }
            if (str.charAt(i) == 'R') isMove = true;
        }

        min = Math.min(min, cnt);

        // 오른쪽으로 파란 공 모으기
        cnt = 0;
        isMove = false;
        for (int i = N - 1; i >= 0; i--) {
            if (isMove && str.charAt(i) == 'B') {
                cnt++;
                continue;
            }
            if (str.charAt(i) == 'R') isMove = true;
        }

        min = Math.min(min, cnt);
        
        bw.write(String.valueOf(min));
        bw.flush();
    }

}