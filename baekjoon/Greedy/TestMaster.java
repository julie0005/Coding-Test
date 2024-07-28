package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 총감독관이 감독할 수 있는 응시자 수가 한 반의 응시자 수보다 많은 경우를 놓침.
 * 즉, 부감독관이 필요 없는 경우를 놓침.
 */

public class TestMaster {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer testNum = Integer.parseInt(st.nextToken());
        List<Integer> takers = new ArrayList<>();
        String[] tokens = br.readLine().split(" ");
        for (int i = 0 ; i < tokens.length; i++) {
            takers.add(Integer.parseInt(tokens[i]));
        }

        st = new StringTokenizer(br.readLine());
        int all = Integer.parseInt(st.nextToken());
        int sub = Integer.parseInt(st.nextToken());

    
        long answer = testNum;
        for (int i=0; i<takers.size(); i++) {
            long student = takers.get(i);
            long temp = Math.max(0, student - all);
            answer += temp % sub > 0 ? temp / sub + 1 : temp / sub;
        }
        
        System.out.println(answer);
    }
    
}
