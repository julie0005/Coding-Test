package programmers.dfsbfs;
class TargetNumber{
    int targetNumber;
    int[] elements;
    int answer = 0;
    public void dfs(int idx,int sum){
        if(idx==elements.length-1){
            if(sum==targetNumber) answer++;
            return;
        }
        dfs(idx+1, sum+elements[idx+1]);
        dfs(idx+1, sum-elements[idx+1]);
    }
    public int solution(int[] numbers, int target) {
        targetNumber=target;
        elements=numbers;
        dfs(0,elements[0]);
        dfs(0,-elements[0]);
        return answer;
    }
}