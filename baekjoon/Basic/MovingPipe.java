package baekjoon.Basic;


import java.io.*;
import java.util.*;

public class MovingPipe {
    static int[][] board;
    static int answer=0;
    static int N;
    static int HOR=0;
    static int VER=1;
    static int DIAG=2;

    static void solution(int currentRow, int currentCol, int prevDirection){
        if(currentRow==N-1 && currentCol==N-1){
            answer++;
            return;
        }
        if(prevDirection==HOR){
            if(isMovable(currentRow, currentCol+1))  solution(currentRow, currentCol+1, HOR);
            if(isMovable45(currentRow+1, currentCol+1)) solution(currentRow+1, currentCol+1, DIAG);
        }
        else if(prevDirection==VER){
            if(isMovable(currentRow+1, currentCol)) solution(currentRow+1, currentCol, VER);
            if(isMovable45(currentRow+1, currentCol+1)) solution(currentRow+1, currentCol+1, DIAG);
        }
        else if(prevDirection==DIAG){
            if(isMovable(currentRow, currentCol+1))  solution(currentRow, currentCol+1, HOR);
            if(isMovable(currentRow+1, currentCol)) solution(currentRow+1, currentCol, VER);
            if(isMovable45(currentRow+1, currentCol+1)) solution(currentRow+1, currentCol+1, DIAG);
        }
    }

    static boolean isMovable(int row, int col){
        if(row<N && col<N && board[row][col]==0) return true;
        return false;
    }

    static boolean isMovable45(int row, int col){
        if(row<N && col<N && board[row][col]==0 && board[row-1][col]==0 && board[row][col-1]==0) return true;
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;
        N=Integer.parseInt(br.readLine());
        board=new int[N][N];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        solution(0,1,HOR);
        System.out.println(answer);
    }
}
