/*
1325 효율적인 해킹
dfs/bfs 문제
1. 인접 행렬로 푸니 메모리 초과 256mb인데 [10000][10000]은 문제가 됨. => 인접리스트로 풀어야.
*/

#include <iostream>
using namespace std;
typedef struct{
    int maxHackCount=0;
    int connected=0;
    bool visited=false;
}computers;

int node, edge;
int start=1;
int graph[10001][10001];
computers computer[10001];

void dfs(int curNode){
    if(!computer[curNode].connected) return;
    computer[start].maxHackCount++;
    for(int i=1; i<=node ;i++){
        if(graph[curNode][i] && !computer[i].visited){
            computer[i].visited=true;
            dfs(i);
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
        graph[hack_start][hack_target]=1;
        computer[hack_start].connected++;
    }
    for(int i=1; i<=node; i++){
        start=i;
        for(int j=1; j<=node; j++){
            computer[j].visited=false;
        }
        dfs(start);
    }
    int max=0;
    int maxi=1;
    for(int i=1; i<=node; i++){
        if(max<=computer[i].maxHackCount){
            maxi=i;
            max=computer[i].maxHackCount;
            cout<<maxi<<" ";
        }
    }
    
}