package baekjoon.Basic;
/* 1978 소수찾기*/

import java.io.*;
import java.util.*;
public class FindPrime {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int answer=0;
        boolean[] notPrime=new boolean[1001];
        StringTokenizer st=new StringTokenizer(br.readLine());
        notPrime[0]=notPrime[1]=true;
        for(int i=2; i*i<=1000; i++){
            if(!notPrime[i]){
                for(int j=i*i;j<=1000;j+=i) notPrime[j]=true;
            }
        }
        
        for(int i=0; i<N; i++){
            int num=Integer.parseInt(st.nextToken());
            if(!notPrime[num]) answer++;
        }
        System.out.println(answer);

    }
}
