package programmers.sort;

import java.util.*;
public class Hindex {
    public int solution(int[] citations) {
        int answer = 0;
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0; i<arr.length; i++) {
            int cnt = i+1;
            if (arr[i] >= cnt) {
                answer = cnt;
            }
            else break;
        }
        return answer;
    }
}
