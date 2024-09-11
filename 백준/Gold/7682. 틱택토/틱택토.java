import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] board;
    
	public static void main(String[] args) throws Exception {
	    while(true) {
	        String str = br.readLine();
	        if (str.equals("end")) break;
	        
	        int xCnt = 0;
	        int oCnt = 0;
	        board = new char[3][3];

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                board[i][j] = str.charAt(i*3 + j);
	                if (board[i][j] == 'X') xCnt++;
	                else if (board[i][j] == 'O') oCnt++;
	            }
	        }

	        if (xCnt + oCnt == 9) { // 1. 게임판이 꽉 채워짐
	            if (xCnt - oCnt != 1) { 
	                // 1-1. X개수가 O개수보다 무조건 1만큼 더 커야함
	                bw.write("invalid\n");
	                continue;
	            }
	            
	            if (bingo('O') && bingo('X')) {
	                bw.write("invalid\n");
	                continue;
	            } else if (bingo('O')) {
	                bw.write("invalid\n");
	                continue;
	            } else {
	                bw.write("valid\n");
	                continue;
	            }
	        } else { // 2. 게임판 안 채워짐
	            if (bingo('O') && bingo('X')) {
	                bw.write("invalid\n");
	                continue;
	            } else if (bingo('X') && xCnt == oCnt + 1) {
	                bw.write("valid\n");
	                continue;
	            } else if (bingo('O') && oCnt == xCnt) {
	                bw.write("valid\n");
	                continue;
	            } else {
	                bw.write("invalid\n");
	                continue;
	            }
	        }
	    }

		bw.flush();
	}
	
	private static boolean bingo(char target) {
	    // 가로 check
	    for (int i = 0; i < 3; i++) {
	        int cnt = 0;
	        for (int j = 0; j < 3; j++) {
	            if (board[i][j] == target) cnt++;
	        }
	        if (cnt == 3) return true;
	    }
	    
	    // 세로 check
	    for (int j = 0; j < 3; j++) {
	        int cnt = 0;
	        for (int i = 0; i < 3; i++) {
	            if (board[i][j] == target) cnt++;
	        }
	        if (cnt == 3) return true;
	    }
	    
	    // 대각선 check
	    if (board[0][0] == target && board[1][1] == target && board[2][2] == target) return true;
	    if (board[0][2] == target && board[1][1] == target && board[2][0] == target) return true;
	    
	    return false;
	}
}