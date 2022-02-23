package baekjoon.BruteForce;
import java.io.*;
import java.util.*;
public class PutOperator {

    static int answer=0;

    public static int calculate(int a, int b, int operator){
        if(operator==0){
            return a+b;
        }
        if(operator==1){
            return a-b;
        }
        if(operator==2){
            return a*b;
        }
        if(operator==3){
            return a/b;
        }
        else return -1;
    }

    public static void dfs(int res, int curIdx){

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] seq=new int[N];
        int[] operatorNum=new int[4];

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        for(int i=0; i<seq.length; i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operatorNum[i]=Integer.parseInt(st.nextToken());
        }

    }
}
