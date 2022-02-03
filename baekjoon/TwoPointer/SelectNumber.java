package baekjoon.TwoPointer;
/*2230 수 고르기
수열이 "정수"로 이루어져 있고, 정렬 보장x. 랜덤.
부분합 투포인터가 적용될 수 있었던 이유는 합이 결국 뒤로 더하면 어차피 커지니, start를 옮기며 수를 뺐던 것.
하지만 정수, 랜덤일 경우 한 방향으로 진행한다고 조건을 만족하는 경우를 놓치지 않는다는 보장 없음.
이에 한방향으로 진행해도 조건을 모두 만족할 수 있도록 정렬.
*/
import java.io.*;
import java.util.*;
public class SelectNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] seq=new int[N];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            seq[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seq);
        int start=0, end=0, diff=0, minDiff=-1;
        while(start<N-1 && end<N){
            
            if(diff>=M || end==N-1){
                start++;
            }
            else end++;
            diff=Math.abs(seq[end]-seq[start]);
            if(diff>=M && (minDiff==-1 || minDiff>diff  )) minDiff=diff; 
        }
        System.out.println(minDiff);
    }
}
