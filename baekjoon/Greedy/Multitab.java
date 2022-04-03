package baekjoon.Greedy;
/*
1700 멀티탭 스케줄링
*풀이계획
1. 칸이 있는 경우 - 꽂는다.
2. 칸이 없는 경우 - 빼고 꽂는다.
- 무엇을 빼는가?
2-1. 현재 꽂혀있는 콘센트들 중에 가장 나중에 적게 사용되는 녀석을 뺀다
모두 빈도가 같다면? 가장 나중에 등장하는 녀석을 뺀다.
솔루션 잘못됨.
빈도와 상관없이 가장 나중에 등장하는 녀석을 빼야함.
*/
import java.io.*;
import java.util.*;
public class Multitab {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int holes=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] seq=new int[K];
        st=new StringTokenizer(br.readLine());

        int[] position=new int[K+1];
        boolean[] isPlugged=new boolean[K+1];
        int[] counts=new int[K+1]; //빈도수
    
        for(int i=0; i<K; i++){
            seq[i]=Integer.parseInt(st.nextToken());
            counts[seq[i]]++;
        }
        int[] multitab=new int[holes];
        int unplugged=holes;
        int plugIdx=0; //아직 멀티탭이 다 차지 않았을 때 꽂을 수 있는 플러그.
        int answer=0;
        for(int i=0; i<K; i++){
            System.out.println("플러그 : "+seq[i]);
            System.out.println("unplugged : "+unplugged);
            System.out.println("현재 플러그 상태 : ");

            for(int j=0; j<K; j++){
                if(isPlugged[j+1]) System.out.print(j+1+" ");
            }
            System.out.print("\n");

            counts[seq[i]]--;
            
            if(isPlugged[seq[i]]){

                continue;
            }
            if(unplugged>0){
                // 칸이 있는 경우
                position[seq[i]]=plugIdx;
                multitab[plugIdx++]=seq[i];
                unplugged--;
                isPlugged[seq[i]]=true;

                continue;
            }

            //칸이 없는 경우
            int next=0;
            int maintainTime=0;
            for(int obj : multitab){
                if(counts[obj]==0){
                    next=obj;
                    break;
                }
                for(int j=i+1; j<K; j++){
                    if(obj==seq[j] && j>maintainTime){
                        maintainTime=j;
                        next=obj;
                        break;
                    }
                }
            }

            System.out.println("next : "+next);
            multitab[position[next]]=seq[i];
            position[seq[i]]=position[next];
            isPlugged[next]=false;
            isPlugged[seq[i]]=true;
            answer++;
        }
        System.out.println(answer);
    }
}
