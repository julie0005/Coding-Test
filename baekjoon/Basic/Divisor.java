package baekjoon.Basic;
import java.io.*;
import java.util.*;

public class Divisor {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int divisorNum=0;
        for(int i=1; i<=N; i++){
            if(N%i==0){
                divisorNum++;
            }
            if(divisorNum==K){
                System.out.println(i);
                break;
            }
        }
        if(divisorNum<K) System.out.println(0);
    }
}
