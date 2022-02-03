package baekjoon.TwoPointer;
/*1644 소수의 연속합
Point : 투포인터 이용, N보다 작은 소수까지로 전체 배열 생성.
*/
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.*;
public class PrimeSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> primeNumbers=new ArrayList<Integer>();
        int N=Integer.parseInt(br.readLine());
        boolean[] notPrime=new boolean[N+1];
        //소수 구하기 : 에라토스테네스의 체 (O(nloglogn))
        notPrime[0]=notPrime[1]=true;
        for(int i=2; i*i<=N; i++){
            if(!notPrime[i]){ 
                // 4의 배수들은 이미 2의 배수에서 걸러짐. 소수의 배수들을 거르는 효과.
                for(int j=i*i ; j<=N; j+=i) notPrime[j]=true;
            }
            
        }
        for(int i=2; i<=N; i++){
            if(!notPrime[i]){
                primeNumbers.add(i);
            }
        }

        int size=primeNumbers.size();
        int start=0, end=0;
        int sum=0, answer=0;
        while(start<size && end<=size){
            if(end==size || sum>=N){
                sum-=primeNumbers.get(start++);
            }
            else{
                sum+=primeNumbers.get(end++);
            }
            if(N==sum) answer++;
        }
        System.out.println(answer);
    }
}
