package baekjoon.TwoPointer;
/*1806 부분합*/
import java.io.*;
import java.util.*;
public class PartialSum {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int[] seq=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        int start=0, end=0, sum=0, len=0, minLen=100000;
        while(start<N && end<=N){ //start<=N으로 설정하면 N일때 배열 access, index out of bound.
            // end==N일 때는 else가 아닌 if문으로 들어가기 때문에 access할 일 없음.
            if(end==N || sum>=S){
                sum-=seq[start++];
                len--;
            }
            else{
                sum+=seq[end++];
                len++;
            }
            if(sum>=S && minLen>len) minLen=len; 
        }
        if(minLen==100000) minLen=0;
        System.out.println(minLen);
    }
}
