package programmers.basic;

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
