package baekjoon.Basic;
import java.io.*;
public class PrimeNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int M=Integer.parseInt(br.readLine());
        int N=Integer.parseInt(br.readLine());

        boolean[] notPrime=new boolean[10001];
        notPrime[0]=notPrime[1]=true;
        for(int i=2; i*i<=10000; i++){
            if(!notPrime[i]){
                for(int j=i*i; j<=10000; j+=i) notPrime[j]=true;
            }
        }
        int sum=0;
        int min=0;
        boolean done=false;
        for(int i=M; i<=N; i++){
            if(!notPrime[i]){
                sum+=i;
                if(!done){
                    min=i;
                    done=true;
                }
            }
        }
        if(sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
