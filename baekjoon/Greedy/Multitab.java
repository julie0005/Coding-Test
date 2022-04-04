package baekjoon.Greedy;
import java.io.*;
import java.util.*;
public class Multitab {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int holes = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list=new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Set<Integer> set = new HashSet<>(); //멀티탭

        int cnt = 0;
        for(int i=0; i<k; i++){
            int num = list.get(i); // 현재 꽂는 전자제품
            if(set.contains(num)) continue; // 이미 꽂아져 있으면 넘김 
            if(set.size()<holes && set.add(num)) continue; // 자리가 남아있으면 전자제품 추가

            //자리 없어서 뺄 놈 정해야하는 경우
            //뺐을 때 그 플러그 자리를 최대한 오래 사용할 수 있는 전자제품 = optimal solution
            //한번도 등장하지 않는 경우, 가장 늦게 등장하는 경우
            int max = -1, idx = -1;
            for(int s : set){
                int duration=0;
                List<Integer> sub=list.subList(i+1, k);
                if(sub.contains(s)){
                    //만약 나중에 이 전자제품이 등장한다면
                    duration = sub.indexOf(s)+1;
                }
                else{
                    //한번도 등장하지 않는다면
                    duration=k-i-1;
                }
                if(duration > max){
                    max = duration;
                    idx = s;
                }
            }
            set.remove(idx);
            set.add(num);
            cnt++;
            
        }
        System.out.println(cnt);
    }
}
