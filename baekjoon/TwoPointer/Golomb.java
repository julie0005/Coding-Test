package baekjoon.TwoPointer;
/*
2038 골롱 수열
*/
import java.io.*;
import java.util.*;
public class Golomb {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> golong=new ArrayList<Integer>();
        golong.add(0);
        golong.add(1);
        int nextIdx=2;
        int nextNum=1;
        while(nextIdx<=n){
            //섹션 시작
            nextNum=nextNum+1;
            golong.add(nextNum);
            int len=golong.get(nextNum);
            for(int i=0; i<len-1; i++){
                golong.add(nextNum);
            }
            nextIdx=golong.size();
        }
        System.out.println(nextNum);
    }
}


