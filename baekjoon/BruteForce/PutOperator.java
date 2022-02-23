package baekjoon.BruteForce;
/*14888 연산자 끼워넣기*/
import java.io.*;
import java.util.*;
public class PutOperator {

    static int answer=0;
    static int[] seq;
    static int[] operators;
    static boolean[] visited;
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;

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
        if(curIdx>=seq.length){
            max=Math.max(max,res);
            min=Math.min(min,res);
            return;
        }
        
        for(int i=0; i<operators.length; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(calculate(res,seq[curIdx],operators[i]),curIdx+1);
                visited[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        seq=new int[N];
        operators=new int[N-1];
        visited=new boolean[N-1];

        StringTokenizer st=new StringTokenizer(br.readLine());
        
        for(int i=0; i<seq.length; i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        int idx=0;
        for(int i=0; i<4; i++){
            int operatorsNum=Integer.parseInt(st.nextToken());
            for(int j=0; j<operatorsNum; j++){
                operators[idx]=i;
                idx++;
            }
        }

        dfs(seq[0],1);

        System.out.println(max);
        System.out.println(min);

    }
}
