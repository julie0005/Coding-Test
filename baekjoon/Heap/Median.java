package baekjoon.Heap;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Median {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        StringTokenizer st=null;
        for(int i=0; i<testCase; i++){
            int qSize=Integer.parseInt(br.readLine());
            int[] seq=new int[qSize];
            q.clear();
            int lineSize=(qSize%10==0) ? qSize/10 : qSize/10+1;
            
            for(int l=0; l<lineSize; l++){
                st=new StringTokenizer(br.readLine());
                int oneLineSize=(qSize-l*10)>10 ? 10 : qSize-l*10;
                for(int j=l*10; j<l*10+oneLineSize; j++){
                    seq[j]=Integer.parseInt(st.nextToken());
                }
            }
           
            System.out.println((qSize+1)/2);
            int elemNum=0;
            for(int j=0; j<qSize; j+=2){
                q.clear();
               
                for(int k=0; k<=j; k++){
                    q.offer(seq[k]);
                }
                
                for(int m=0; m<=j/2; m++){
                    int elem=q.poll();
                    if(m==j/2) {
                        System.out.print(elem);
                        elemNum++;
                        break;
                    }
                }
                if(j==qSize-1 || elemNum%10==0) System.out.print("\n");
                else System.out.print(" ");
            }

        }
    }
}
