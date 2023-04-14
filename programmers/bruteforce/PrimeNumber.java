package programmers.bruteforce;
import java.util.*;
/* 프로그래머스 소수 찾기
 * 1. n이 소수 인지 확인하는 법
 * 2. 모든 조합 비교
 */
class PrimeNumber {
    HashSet<Integer> numberComb = new HashSet<>();
    
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public void exaustiveSearch(String comb, String others) {
        if (!comb.equals("")) {
            numberComb.add(Integer.valueOf(comb));
        }
        for(int i=0; i<others.length(); i++) {
            exaustiveSearch(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }
    public int solution(String numbers) {
        exaustiveSearch("", numbers);
        int answer = 0;
        for(Integer num : numberComb) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
}
