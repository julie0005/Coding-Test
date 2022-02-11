package baekjoon.Basic;
import java.io.*;
import java.util.*;

public class BinaryNumber {
    static ArrayList<Integer> binary_num=new ArrayList<Integer>();
    static void dec_to_bin(int num){
        int divided=num;
        while(divided!=1){
            binary_num.add(divided%2);
            divided=divided/2;
        }
        binary_num.add(1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int testCase=Integer.parseInt(st.nextToken());
        for(int i=0; i<testCase; i++){
            binary_num.clear();
            st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            dec_to_bin(N);
            for(int j=0; j<binary_num.size(); j++){
                if(binary_num.get(j)==1){
                    System.out.print(j);
                    if(j==binary_num.size()-1) System.out.print("\n");
                    else System.out.print(" ");
                }
            }
            
        }
    }
}
