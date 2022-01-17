/*
촌수 계산
dfs/bfs
정답이 있는 숫자까지의 edge 길이를 구하는 문제
: 유동적으로 '현재 node'까지의 길이를 구하는 식으로 풀었다. dfs 리턴되면 ans--.
정답이 있는 숫자까지 이어져있지 않으면 -1을 출력한다.


*/
#include <iostream>
using namespace std;
const int MAX=100+1;
int total;
int target1, target2, relations;
int graph[MAX][MAX];
bool visited_vertices[MAX]={false};
int answer=0;
bool isFound=false;
void dfs(int curNode){
    
    for(int i=1; i<=total; i++){
        if(graph[curNode][i] && !visited_vertices[i]){
            answer++; 
            visited_vertices[i]=true;
            if(i==target2) { isFound=true; return;}
           
            dfs(i);
            if(!isFound) answer--;
            else return; //이 구문이 없으면 정답을 찾았음에도 다음 형제노드에 대해 dfs를 진행하게 됨.
        }
    }
    if(curNode==target1 && !isFound) answer=-1;
}


int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>total>>target1>>target2>>relations;

    for(int i=1; i<=relations; i++){
        int parent, child;
        cin>>parent>>child;
        graph[parent][child]=1;
        graph[child][parent]=1;
    }
    
    visited_vertices[target1]=true;
    dfs(target1);
    cout<<answer<<'\n';
}