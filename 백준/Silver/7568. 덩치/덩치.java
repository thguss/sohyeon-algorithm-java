import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Size {
        int weight;
        int height;
        int rank = 1;

        public Size (int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    
    public static void main(String[] args) throws Exception {
        int N = Integer.valueOf(br.readLine());

        List<Size> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.valueOf(st.nextToken());
            int height = Integer.valueOf(st.nextToken());
            al.add(new Size(weight, height));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (al.get(i).weight < al.get(j).weight && al.get(i).height < al.get(j).height) {
                        al.get(i).rank++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(al.get(i).rank + " "));
        }
        bw.flush();
    }

}