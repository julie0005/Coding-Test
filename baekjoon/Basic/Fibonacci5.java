package baekjoon.Basic;
/* 10870 피보나치수 5*/
import java.io.*;
import java.util.*;
public class Fibonacci5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int order=2;
        int a=0;
        int b=1;
        int c=1;
        while(order<=n){
            c=a+b;
            a=b;
            b=c;
            order++;
        }
        if(n<2) System.out.println(n);
        else System.out.println(c);
    }
}
