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
        int N = Integer.valueOf(br.readLine());

        Deque<String> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            stack1.push(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            if (key.equals("P")) {
                String x = st.nextToken();
                stack1.push(x);
            } else if (key.equals("L")) {
                if (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            } else if (key.equals("D")) {
                if (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            } else if (key.equals("B")) {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        while (!stack1.isEmpty()) {
            bw.write(stack1.removeLast());
        }
        while (!stack2.isEmpty()) {
            bw.write(stack2.pop());
        }

        bw.flush();
    }

}