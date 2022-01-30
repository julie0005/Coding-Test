package baekjoon.DFSBFS;
/*
1697 숨바꼭질
Point : 큐에서 그래프의 depth를 어떻게 표시할거니?
Queue에 int 배열 자료형을 element로 가지게 함으로써 해결.
자식의 depth는 부모 depth+1.
DFS로 하면 답이 없는 경로로 무한히 파고들기 때문에 BFS가 맞다고 판단.
*/
import java.io.IOException;
import java.util.Scanner;

import java.util.Queue;
import java.util.LinkedList;
public class HideAndSeek {
    static int MAX=100000;
    static boolean[] visited=new boolean[MAX+1];
    static int targetLocation;
    static void bfs(int location){
        int[] initArray={location,0};
        Queue<int[]> q=new LinkedList<int[]>();
        visited[location]=true;
        q.offer(initArray);
        while(!q.isEmpty()){
            int[] curArr=q.poll();
            int curLoc=curArr[0];
            int curTick=curArr[1];

            if(curLoc==targetLocation){
                System.out.println(curTick);
                break;
            }
            
            visit(curLoc+1, q, curTick+1);
            visit(curLoc-1, q, curTick+1);
            visit(2*curLoc,q, curTick+1);
        }
    }

    static void visit(int nextLocation, Queue<int[]> q, int ticks){
        if(nextLocation>=0 && nextLocation<=MAX && !visited[nextLocation]){
            visited[nextLocation]=true;
            int[] param={nextLocation, ticks};
            q.offer(param);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int initLocation=sc.nextInt();
        targetLocation=sc.nextInt();
        bfs(initLocation);
    }
}