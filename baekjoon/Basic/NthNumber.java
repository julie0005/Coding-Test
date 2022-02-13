package baekjoon.Basic;
/*2693 N번째 큰 수*/
import java.io.*;
import java.util.*;

public class NthNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        int[] seq=new int[10];
        for(int i=0; i<T; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++){
                seq[j]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(seq);
            System.out.println(seq[7]);
        }
        

    }
}
