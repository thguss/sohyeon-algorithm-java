import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<Character> al = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        String type = st.nextToken();

        Set<String> names = new HashSet<>();
        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        if (type.equals("Y")) {
            int res = names.size();
            bw.write(String.valueOf(res));
        } else if (type.equals("F")) {
            int res = names.size() / 2;
            bw.write(String.valueOf(res));
        } else if (type.equals("O")) {
            int res = names.size() / 3;
            bw.write(String.valueOf(res));
        }
        
        bw.flush();
    }


}