import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        int M = Integer.valueOf(br.readLine());
        List<Integer> al = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("all")) {
                al.clear();
                for (int j = 1; j <= 20; j++) {
                    al.add(j);
                }
            } else if (cmd.equals("empty")) {
                al.clear();
            } else {
                int x = Integer.valueOf(st.nextToken());
                if (cmd.equals("add")) {
                    if (!al.contains(x)) al.add(x);
                } else if (cmd.equals("remove")) {
                    if (al.contains(x)) al.remove(Integer.valueOf(x));
                } else if (cmd.equals("check")) {
                    int check = al.contains(x) ? 1 : 0;
                    bw.write(String.valueOf(check) + "\n");
                } else if (cmd.equals("toggle")) {
                    if (!al.contains(x)) {
                        al.add(x);
                    } else al.remove(Integer.valueOf(x));
                }
            }
        }

        bw.flush();
    }
}