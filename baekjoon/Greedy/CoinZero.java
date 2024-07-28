package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CoinZero {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        int sum = 0;
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            sum = Integer.parseInt(st.nextToken());
        
            for (int i=0; i<line; i++) {
                st = new StringTokenizer(br.readLine());
                values.add(Integer.parseInt(st.nextToken()));
            }
        } catch (IOException e) {
            System.out.println(-1);
        }
        
        Collections.sort(values, (v1,v2) -> v2 - v1);
        for (int i=0; i<values.size(); i++) {
            if (values.get(i) > sum) continue;
            int currentCount = sum / values.get(i);
            count += currentCount;
            sum -= values.get(i) * currentCount;
            if (sum <= 0) break;
        }
        System.out.println(count);
    }
    
}
