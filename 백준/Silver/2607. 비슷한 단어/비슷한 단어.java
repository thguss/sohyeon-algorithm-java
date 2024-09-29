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
        String word = br.readLine();
        int[] arr = new int['Z' - 'A' + 1];
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'A';
            arr[idx]++;
        }

        int cnt = 0;

        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            if (similar(arr, word, str)) cnt++;
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static boolean similar(int[] arr, String word, String str) {
        if (Math.abs(word.length() - str.length()) > 1) return false;

        int[] copyArr = arr.clone();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            if (copyArr[idx] > 0) {
                copyArr[idx]--;
                cnt++;
            }
        }

        if (word.length() == str.length()) {
            return cnt == str.length() || cnt == str.length() - 1;
        }

        if (word.length() == str.length() + 1) {
            return cnt == str.length();
        }

        if (word.length() == str.length() - 1) {
            return cnt == word.length();
        }
        
        return false;
    }

}