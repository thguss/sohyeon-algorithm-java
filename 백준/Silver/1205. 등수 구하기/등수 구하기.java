import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        long score = Long.valueOf(st.nextToken());
        int size = Integer.valueOf(st.nextToken());

        List<Long> al = new ArrayList<>();

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                al.add(Long.valueOf(st.nextToken()));
            }

            Collections.sort(al, (a, b) -> Long.compare(b, a));
        }

        if (N == 0) bw.write("1");

        else if (al.size() == size && score <= al.get(al.size() - 1)) {
            bw.write("-1");
        } else {
            if (al.size() < N && score < al.get(al.size() - 1)) {
                bw.write(String.valueOf(al.size() + 1));
            } else {
                int rank = 0;

                //System.out.println(al);
                
                for (int i = 0; i < al.size(); i++) {
                    if (al.get(i) > score) {
                        rank++;
                    } else {
                        break;
                    }
                }

                if (N == size && rank > size) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(rank + 1));
                }
            }
        }

        bw.flush();
    }


}