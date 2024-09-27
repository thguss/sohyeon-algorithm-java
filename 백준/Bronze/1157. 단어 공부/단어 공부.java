import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        String str = br.readLine().toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        int max = 0;
        char ans = '?';
        for (char ch : map.keySet()) {
            int cnt = map.get(ch);
            if (cnt > max) {
                ans = ch;
                max = cnt;
            } else if (cnt == max) {
                ans = '?';
            }
        }

        bw.write(Character.toString(ans));
        bw.flush();
    }
}