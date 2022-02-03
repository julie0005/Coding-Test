package baekjoon.TwoPointer;
/* 2003 수들의 합2 
TwoPointer 예제
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Sum2 {
    static int MAX=10000;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int targetSum=Integer.parseInt(st.nextToken());
        int[] seq=new int[MAX+1];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            seq[i]=Integer.parseInt(st.nextToken());
        }
        int start=0, end=0;
        int sum=0;
        int answer=0;
        while(start<=size && end<=size){
            if(sum>=targetSum || end==size){
                sum-=seq[start];
                start++;
            }
            else {
                sum+=seq[end];
                end++;
            }
            if(sum==targetSum) answer++;
        }
        System.out.println(answer);
    }
}
