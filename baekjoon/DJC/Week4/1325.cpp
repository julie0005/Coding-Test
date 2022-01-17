/*
1325 효율적인 해킹
dfs/bfs 문제
삽질 기록
1. 인접 행렬로 푸니 메모리 초과 256mb인데 [10000][10000]은 문제가 됨. => 인접리스트로 풀어야.
2. 마지막 최댓값 구하는 부분에서 벡터 리스트를 모두 순회해야만 최댓값을 알 수 있는데 업데이트될 때마다 프린트하게 냅둠.
(max값 오름차순으로 프린트해야한다는 것에 집중하다가 다 순회하고 해야하는데, 첫 순회에서 그래버림.)
3. A가 B를 신뢰하면, A와 B 모두 해킹할 수 있다는 것을 최대 깊이로 오해함.
*/

#include <iostream>
#include <vector>
using namespace std;
typedef struct{
    int maxHackCount=1;
    int connected=0;
    bool visited=false;
}computers;

int node, edge;
int start=1;
vector<int> graph[10001];
computers computer[10001];

void dfs(int curNode){
    if(!computer[curNode].connected) return;
    for(int v : graph[curNode]){
       
        if(!computer[v].visited){
            computer[start].maxHackCount++;
            computer[v].visited=true;
            dfs(v);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>node>>edge;
    for(int i=0; i<edge; i++){
        int hack_target, hack_start;
        cin >> hack_target >> hack_start;
        graph[hack_start].push_back(hack_target);
        computer[hack_start].connected++;
    }
    
    for(int i=1; i<=node; i++){
        for(int j=1; j<=node; j++){
            computer[j].visited=false;
        }
        start=i;
        computer[start].visited=true;
        dfs(start);
    }
    int max=0;
    for(int i=1; i<=node; i++){
        if(max<=computer[i].maxHackCount){
            max=computer[i].maxHackCount;
        }
    }
    for(int i=1; i<=node; i++){
        if(max==computer[i].maxHackCount){
            cout<<i<<" ";
        }
    }

}