import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int T = Integer.valueOf(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.valueOf(st.nextToken());
            int[] arr = new int[20];
            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.valueOf(st.nextToken());
            }
            bw.write(String.valueOf(num) + " " + String.valueOf(solve(arr)) + "\n");
        }

        bw.flush();
    }

    private static int solve(int[] arr) {
        int sum = 0;
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int h = arr[i];

            if (al.isEmpty()) {
                al.add(h);
            } else {
                if (h > al.get(al.size() - 1)) {
                    al.add(h);
                } else if (h < al.get(0)) {
                    al.add(0, h);
                    sum += al.size() - 1;
                } else {
                    for (int j = al.size() - 2; j >= 0; j--) {
                        if (h > al.get(j)) {
                            al.add(j + 1, h);
                            sum += al.size() - j - 2;
                            break;
                        }
                    }
                }
            }
        }

        return sum;
    }
}