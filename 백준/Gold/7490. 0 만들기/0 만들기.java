import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static List<String> result;
    
    public static void main(String[] args) throws Exception {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.valueOf(br.readLine());

        while (T-- > 0) {
            N = Integer.valueOf(br.readLine());
            result = new ArrayList<>();
            solve(1, "1");
            Collections.sort(result);
            for (String exp : result) {
                bw.write(exp + "\n");
            }
            bw.write("\n");
        }

        bw.flush();
    }

    static void solve(int num, String expression) {
        if (num == N) {
            if (calculate(expression) == 0) {
                result.add(expression);
            }
            return;
        }

        solve(num + 1, expression + "+" + (num + 1));
        solve(num + 1, expression + "-" + (num + 1));
        solve(num + 1, expression + " " + (num + 1));
    }

    static int calculate(String expression) {
        expression = expression.replace(" ", "");
        StringTokenizer st = new StringTokenizer(expression, "+-", true);
        int sum = Integer.valueOf(st.nextToken());

        while (st.hasMoreTokens()) {
            String operator = st.nextToken();
            int num = Integer.valueOf(st.nextToken());

            if (operator.equals("+")) {
                sum += num;
            } else if (operator.equals("-")) {
                sum -= num;
            }
        }

        return sum;
    }

}