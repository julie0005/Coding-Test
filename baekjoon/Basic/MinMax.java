package baekjoon.Basic;
import java.io.*;
import java.util.*;

public class MinMax {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int cur=Integer.parseInt(st.nextToken());
            maxHeap.offer(cur);
            minHeap.offer(cur);
        }
        System.out.print(minHeap.peek()+" "+maxHeap.peek());
    }
}
