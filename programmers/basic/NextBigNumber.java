package programmers.basic;
/*
 * 프로그래머스 다음 큰 숫자
 * 진수 변환 함수
 */
class NextBigNumber {
    public int binaryOneCount(int n) {
        int cnt = 0;
        while (n>0) {
            if (n % 2 == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
    public int solution(int n) {
        int answer = n;
        int nCnt = binaryOneCount(n);
        while(true) {
            answer++;
            if (binaryOneCount(answer) == nCnt) break;
        }
        return answer;
    }
}
