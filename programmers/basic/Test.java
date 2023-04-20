package programmers.basic;
/*
 * 프로그래머스 모의고사
 * 1. ArrayList로 이루어진 배열 만드는 법
 * 2. Integer arrayList -> int array 만드는 법
 */
import java.util.*;
class Test {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int max = 0;
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer>[] pattern = new ArrayList[3];
        pattern[0] = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        pattern[1] = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        pattern[2] = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        for(int i=0; i<pattern.length; i++) {
            scores[i] = score(answers, pattern[i]);
            max = Math.max(max, scores[i]);
        }
        for (int i=0; i<scores.length; i++) {
            if (max == scores[i]) answer.add(i+1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    int score(int[] answers, List<Integer> pattern) {
        int sum = 0;
        for (int i=0; i<answers.length; i++) {
            if(answers[i] == pattern.get(i % pattern.size())) sum ++;
        }
        return sum;
    }
}