/*
1260. DFS와 BFS
adjacency matrix를 통해 정점과 연결된 상태를 표현.
*/

#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

const int MAX=1000+1; // 정점의 최대 개수는 1000개

int node, edge, start;
int graph[MAX][MAX]; // adjacency matrix
bool visited_vertices[MAX];

void dfs(int curVertex){
    cout<<curVertex<<" ";
    for(int i=1; i<=node; i++){
        if(graph[curVertex][i] && !visited_vertices[i]){
            visited_vertices[i]=true;
            dfs(i);
        }
    }
}

void bfs(int curVertex){
    queue<int> queue;
    queue.push(curVertex);
    visited_vertices[curVertex]=true;
    while(!queue.empty()){
        curVertex=queue.front();
        cout<<curVertex<<' ';
        queue.pop();

        for(int i=1; i<=node; i++){
            if(graph[curVertex][i] && !visited_vertices[i]){
                visited_vertices[i]=true;
                queue.push(i);
            }
        }
    }

}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>node>>edge>>start;
    for(int i=0; i<edge; i++){
        int startNode, endNode;
        cin>>startNode>>endNode;
        graph[startNode][endNode]=1;
        graph[endNode][startNode]=1;
    }
    visited_vertices[start]=1;
    dfs(start);
    cout<<'\n';
    memset(visited_vertices,false,sizeof(visited_vertices));
    bfs(start);
}
