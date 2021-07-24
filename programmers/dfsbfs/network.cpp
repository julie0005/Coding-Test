/*
네트워크
"connected graph를 어떻게 구분할거니?"
N : 컴퓨터 개수, 각 컴퓨터는 0부터 n-1로 표시.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]=1.
고민점: 이미 방문한 노드를 dfs 시작점으로 해서 이어나갔는데 이전에 방문하지 않은 노드를 만나면?
=> 그럴 수 없다. dfs는 leaf 끝까지 가기 때문에 방문하지 않은 노드를 만난다면 그건 이전 시작점에서 걸러졌을 것.
주의: 예제가 reflected graph라고 해서, 아 undirected graph구나 하면 안됨.
문제에서 그런 말은 없었다.
*/
#include <string>
#include <vector>

using namespace std;
vector<vector<int>> graph;
bool visited[200]={false};
int total=0;
void dfs(int computer){
    visited[computer]=true;
    for(int i=0; i<total; i++){
        if(graph[computer][i] && !visited[i])
            dfs(i);
    }
}

int solution(int n, vector<vector<int>> computers) {
    graph=computers;
    total=n;
    int answer=0;
    for(int i=0; i<n; i++){
        if(!visited[i]){
            dfs(i);
            answer++;
        }
    }
    return answer;
}