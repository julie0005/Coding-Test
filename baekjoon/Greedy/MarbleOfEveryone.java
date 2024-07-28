package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class MarbleOfEveryone {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, Collections.reverseOrder());
        int gold = nums[0] + nums[1];
        int highestLevel = nums[0];

        for(int i=2; i<n; i++) {
            gold += highestLevel + nums[i];
        }
        System.out.println(gold);
    }
    
    
}
