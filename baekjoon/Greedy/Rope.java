package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Rope {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer num = Integer.parseInt(st.nextToken());
        List<Integer> ropes = new ArrayList<>();
        
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            ropes.add(weight);
        }

        Collections.sort(ropes, Collections.reverseOrder());

        int max = 0;
        for (int i=0; i<num; i++) {
            int current = ropes.get(i);
            max = Math.max(max, current * (i+1));
        }
        System.out.println(max);
    }
    
}
