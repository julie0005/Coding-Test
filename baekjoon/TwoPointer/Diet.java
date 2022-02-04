package baekjoon.TwoPointer;
/*1484 다이어트
g : 현재^2- 기억^2 = n^2-r^2 = (n-r)(n+r) = end^2-start^2
*/
import java.io.*;
import java.util.*;

public class Diet {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int g=Integer.parseInt(br.readLine());
        int start=1, end=1, res=0;
        boolean isPossible=false;
        while(start<=g){
            if(res>=g || end==g-1){
                start++;
            }
            else end++;
            res=(end-start)*(end+start);
            if(res==g){System.out.println(end); isPossible=true;}
        }
        if(!isPossible) System.out.println(-1);
    }
}
