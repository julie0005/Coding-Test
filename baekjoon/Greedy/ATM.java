package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int[] time = new int[people];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<time.length; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int sum = 0;
        for (int i=0; i<time.length; i++) {
            for(int j=0; j<=i; j++) {
                sum += time[j];
            }
        }
        System.out.println(sum);
    }
    
}
