/*
vector 매개변수로 전달하기 : 함수 호출하고 나서도 영향을 받고 싶다면 call by reference로 전달.
배열 시작주소 &a[0] == a 인것처럼 벡터도 그런가봄. 그래서 solution에서 전달시에는 그냥 쓰고, DFS에서 매개변수로 받을 때는 &이렇게 하나 봄.
& : 참조로 받는다!
*/

#include <string>
#include <vector>

using namespace std;

int total;

void DFS(vector<int> &numbers, int &target,int sum,int n) {
    if(n >= numbers.size()){
        if(sum == target) total++;
        return;
    }

    DFS(numbers, target, sum + numbers[n], n+1);
    DFS(numbers, target, sum - numbers[n], n+1);
}

int solution(vector<int> numbers, int target) {
    int answer = 0;

    DFS(numbers, target, numbers[0] , 1);
    DFS(numbers, target, -numbers[0], 1);

    answer = total;

    return answer;
}
