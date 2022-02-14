package baekjoon.Simulation;
/* 14719 빗물*/
import java.io.*;
import java.util.*;
public class RainWater {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int H=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        int[] wall=new int[W];
        int sum=0;
        int max=0;
        int maxIdx=0;

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            wall[i]=Integer.parseInt(st.nextToken());
            if(max<wall[i]){
                max=wall[i];
                maxIdx=i;
            }
        }
        int leftMax=wall[0];
        for(int i=0; i<maxIdx; i++){
            if(leftMax<wall[i]) leftMax=wall[i];
            else sum+=leftMax-wall[i];
        }

        int rightMax=wall[wall.length-1];
        for(int i=wall.length-1 ; i>maxIdx ; i--){
            if(rightMax<wall[i]) rightMax=wall[i];
            else sum+=rightMax-wall[i];
        }

        System.out.println(sum);

    }
}
