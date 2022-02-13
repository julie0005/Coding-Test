package baekjoon.Basic;
import java.io.*;
import java.util.StringTokenizer;
/*2609 최대공약수와 최소공배수*/
public class GCDLCM {
    static int gcd(int a, int b){
        return a%b==0 ? b : gcd(b, a%b);
    }

    static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
}
