/*
타겟 넘버
n개의 음이 아닌 정수들이 vector<int>로 주어질 때, 이 수들을 적절히 더하거나 빼서 타겟 넘버로 만드는 것이 목표이다.
발상 :
1. 수들은 그대로 있고 +와 -를 수 앞에 껴놓는다는 생각, (-1)*(숫자) 이런식으로 이용해야겠다고 생각함.
2. 경우를 그래프로 만들어보니 2의 n제곱, 이진트리 생각남. 이진트리+dfs
3. 이진트리를 배열로 만들어두고, dfs 재귀함수 생성.
주의 :
1. 배열 인덱스를 변수로 만들었다면 그 변수가 음수가 되지는 않는지 확인하기.
2. depth 같은 경우 상당히 유동적임. 이는 매개변수로 depth를 넣으면 쉽게 제어 가능. dfs 함수 안에서 ++했다가 dfs 함수 뒤에서 다시 --하는 짓 안해도 된다.
더 좋은 방법 :
1. 굳이 숫자와 부호를 분리하지 않아도 dfs 생각 가능.
2. target_number(best).cpp 참고
*/
#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;
int n;
vector<int> graph;
vector<int> staticNumbers;
int staticTarget;
int answer=0;

void dfs(int curNode, int preResult, int depth){ // 매개변수로 depth 넣으면 depth++, depth-- 조절하지 않아도 된다.
    
    int listNumber=depth<1 ? 0 : staticNumbers[depth-1];
    int curResult=preResult+(graph[curNode]*listNumber);
    if(curResult==staticTarget && depth==staticNumbers.size()) answer++;
    if(curNode*2>graph.size() || curNode*2+1>graph.size()) return;
    dfs(2*curNode,curResult, depth+1);
    dfs(2*curNode+1,curResult,depth+1);
}

int solution(vector<int> numbers, int target){
    staticTarget=target;
    staticNumbers=numbers;
    int size=numbers.size();
    
    for(int i=0; i<pow(2,size+1); i++){
        if(i%2==0) graph.push_back(1);
        else graph.push_back(-1);
    }

    dfs(1,0,0);
    return answer;
}

//테스트
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    vector<int> numbers;
    int target;
    
    cin>>n>>target;
    for(int i=0; i<n; i++){
        int element;
        cin>>element;
        numbers.push_back(element);
    }
    cout<<solution(numbers,target)<<'\n';
}