import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<Character> al = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        // StringTokenizer st = new StringTokenizer(br.readLine());
        al.add('a');
        al.add('e');
        al.add('i');
        al.add('o');
        al.add('u');

        while (true) {
            String str = br.readLine();

            if (str.equals("end")) break;

            String res = solve(str);
            bw.write("<" + str + "> is " + res + ".\n");
        }
        
        bw.flush();
    }

    private static String solve(String str) {
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (al.contains(ch)) cnt++;
            
            if (i < str.length() - 1 && ch == str.charAt(i + 1)) {
                if (ch != 'e' && ch != 'o') {
                    return "not acceptable";
                }

                if (i > 0 && ch == str.charAt(i - 1)) {
                    return "not acceptable";
                }
            }

            if (i > 0 && i < str.length() - 1) {
                boolean first = al.contains(str.charAt(i - 1));
                boolean second = al.contains(ch);
                boolean third = al.contains(str.charAt(i + 1));

                if (first == second && second == third && third == first) return "not acceptable";
            }
        }

        if (cnt == 0) return "not acceptable";

        return "acceptable";
    }

}