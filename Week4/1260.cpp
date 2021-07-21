#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

const int MAX = 1000+1;

int node, edge, start;
int graph[MAX][MAX];
bool visited_vertices[MAX];

void dfs(int cur_vertex){
    cout<<cur_vertex<<" ";
    for(int i=1; i<=node;i++){
        if(graph[cur_vertex][i] && !visited_vertices[i]){
            visited_vertices[i]=true;
            dfs(i);
        }
    }
}
void bfs(int cur_vertex){
    queue<int> queue;
    queue.push(cur_vertex);
    visited_vertices[cur_vertex]=true;
    while(!queue.empty()){
        cur_vertex=queue.front();
        queue.pop();
        cout<<cur_vertex<<" ";

        for(int i=1; i<=node; i++){
            if(graph[cur_vertex][i] && !visited_vertices[i]){
                visited_vertices[i]=true;
                queue.push(i);
            }
        }

    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> node >> edge >> start;

    for(int i=0; i<edge ;i++){
        int start_node, end_node;
        cin>>start_node>>end_node;
        graph[start_node][end_node]=1;
        graph[end_node][start_node]=1;
    }

    visited_vertices[start]=1;
    dfs(start);
    cout<<"\n";
    memset(visited_vertices,false,sizeof(visited_vertices));
    bfs(start);
}