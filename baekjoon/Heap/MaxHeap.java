package baekjoon.Heap;
/* 11279 최대힙*/
import java.util.*;
public class MaxHeap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        int num=sc.nextInt();

        for(int i=0; i<num; i++){
            int element=sc.nextInt();
            if(element>0) q.offer(element);
            else{
                if(!q.isEmpty()) System.out.println(q.poll());
                else System.out.println(0);
            }
        }
    }
}
