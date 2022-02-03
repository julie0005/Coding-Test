package baekjoon.Basic;
/* 2960 에라토스테네스의 체
 1644 소수의 연속합 참고.
 이 문제에서는 K번째 지우는 수를 구해야하기 때문에 이미 지운 수를 중복해서 access하더라도 그냥 i부터 순회.
 원래는 i*i<=N, j=i*i.
 access하는 것이 if 많이 검사하는 것보다 속도 빠름.
 */
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Eratosthenes {
    static int MAX=1000;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        boolean[] notPrime=new boolean[N+1];
        notPrime[0]=notPrime[1]=true;
        int order=0;
        for(int i=2; i<=N; i++){
            for(int j=i; j<=N; j+=i){
                if(!notPrime[j]){
                    notPrime[j]=true;
                    order++;
                }
                if(order==K) {System.out.println(j); return;}
            }
            
        }
    }
}
