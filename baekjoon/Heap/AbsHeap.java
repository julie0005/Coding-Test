package baekjoon.Heap;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class AbsHeap {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> q=new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                int result=Integer.compare(Math.abs(n1.intValue()), Math.abs(n2.intValue()));
                if(result==0) return n1.compareTo(n2);
                else return result;
            }
        });
        int num=Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            int elem=Integer.parseInt(br.readLine());
            if(elem!=0){
                q.offer(elem);
            }
            else if(!q.isEmpty()) System.out.println(q.poll());
            else System.out.println(0);
        }
    }
}
