package baekjoon.Heap;
/*
2696 중앙값 구하기
초기 아이디어 : priority queue 한개만 이용하여, 중앙값 도달할 때까지 poll. => 메모리 초과됨. totalLength만큼의 배열, 순회하면서 중앙값까지의 배열 지속적으로 필요.
이후 아이디어: maxHeap과 minHeap을 둬서 홀수 번째일 때는 maxHeap 삽입, 짝수 번째일 때는 minHeap 삽입. maxHeap 삽입했을 때마다 minHeap의 peek과 maxHeap의 peek 비교하여 maxHeap의 최대가
minHeap의 최소보다 크다면 swap. => maxHeap은 중앙값 이하의 값, minHeap은 중앙값 초과의 값들을 가지고 있게 함.
*/
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Median {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
        StringTokenizer st=null;
        for(int i=0; i<testCase; i++){
            int totalLength=Integer.parseInt(br.readLine());
            int[] seq=new int[totalLength];
            int lineSize=(totalLength%10==0) ? totalLength/10 : totalLength/10+1;
            minHeap.clear();
            maxHeap.clear();
            for(int l=0; l<lineSize; l++){
                st=new StringTokenizer(br.readLine());
                int oneLineSize=(totalLength-l*10)>10 ? 10 : totalLength-l*10;
                for(int j=l*10; j<l*10+oneLineSize; j++){
                    seq[j]=Integer.parseInt(st.nextToken());
                }
            }
            System.out.println((totalLength+1)/2);
            int elemNum=0;
            for(int j=0; j<totalLength; j++){
                int elem=seq[j];
                if(j%2==0){
                    elemNum++;
                    maxHeap.offer(elem);
                    if(!minHeap.isEmpty() && minHeap.peek()<maxHeap.peek()){
                        maxHeap.offer(minHeap.poll());
                        minHeap.offer(maxHeap.poll());
                    }
                    System.out.print(maxHeap.peek());
                    if(elemNum%10==0 || elemNum==(totalLength+1)/2) System.out.print("\n");
                    else System.out.print(" ");
                }
                else minHeap.offer(elem);
            }

        }
    }
}
