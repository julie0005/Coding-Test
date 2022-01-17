/*
토마토.

bfs의 시작점들을 queue에 넣고 시작함으로써 여러 군데에서 번갈아가며 퍼지게 하는 효과를 줄 수 있음.


*/

#include <iostream>
#include <queue>
using namespace std;

int graph[1000][1000];
bool visited[1000][1000]={false};
int height, width;

int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};

typedef struct{
    int row;
    int col;
    int depth;
}place;

int bfs(){
    queue<place> queue;
    int answer;
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            if(!visited[i][j] && graph[i][j]==1){
                queue.push({i,j,0});
                visited[i][j]=true;
            }
        }
    }

    while(!queue.empty()){
        int row=queue.front().row;
        int col=queue.front().col;
        int depth=queue.front().depth;
        queue.pop();

        for(int i=0; i<4; i++){
            int nextRow=row+dRow[i];
            int nextCol=col+dCol[i];
            if(nextRow>=0 && nextCol>=0 && nextRow<height && nextCol<width){
                if(!graph[nextRow][nextCol] && !visited[nextRow][nextCol]){
                    queue.push({nextRow, nextCol, depth+1});
                    graph[nextRow][nextCol]=1;
                    visited[nextRow][nextCol]=true;
                }
            }

        }
        answer=depth;
    }

    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            if(!graph[i][j]) answer=-1;
        }
    }
    return answer;
}

int main(){
    bool isAllRipe=true;
    cin>>width>>height;

    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            cin>>graph[i][j];
            if(isAllRipe && !graph[i][j]){
                isAllRipe=false;
            }
        }
    }

    if(isAllRipe){
        cout<<0<<"\n";
        return 0;
    }

    cout<<bfs()<<"\n";


    return 0;
}