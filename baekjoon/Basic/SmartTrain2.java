package baekjoon.Basic;
/*2460 지능형 기차2*/

import java.io.*;
import java.util.*;

public class SmartTrain2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        StringTokenizer st=null;
        int totalTrain=0;
        for(int i=0; i<10; i++){
            st=new StringTokenizer(br.readLine());
            int down=Integer.parseInt(st.nextToken());
            int up=Integer.parseInt(st.nextToken());
            totalTrain=totalTrain-down+up;
            maxHeap.offer(totalTrain);
        }
        System.out.println(maxHeap.peek());
    }
}
