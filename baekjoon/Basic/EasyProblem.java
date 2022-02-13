package baekjoon.Basic;
/*1292 쉽게 푸는 문제*/
import java.io.*;
import java.util.*;
public class EasyProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        int[] seq=new int[1001];
        int idx=0;
        int num=1;
        while(true){
            for(int i=0;i<num && idx<1001; i++){
                seq[idx++]=num;
            }
            num++;
            if(idx>end) break;
        }
        
        int sum=0;
        for(int i=start-1; i<end; i++){
            sum+=seq[i];
        }
        System.out.println(sum);
    }
}
