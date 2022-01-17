/*
현재 상태를 관리하기 어렵다면 매개변수로.
=>2차원 배열은 모두 call by reference이므로, call by value를 사용할 수 있는 2차원 vector 사용.
=>call by value시, 그래프의 현재 상태 고려하기!
*/
#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

int height, width;

int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};
int answer=0;

void bfs(vector<vector<int>> graph){
    queue<pair<int,int>> queue;
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            if(graph[i][j]==2){
                queue.push({i,j});
            }
        }
    }

    while(!queue.empty()){
        int row=queue.front().first;
        int col=queue.front().second;
        queue.pop();

        for(int i=0; i<4; i++){
            int nextRow=row+dRow[i];
            int nextCol=col+dCol[i];

            if(nextRow>=0 && nextCol>=0 && nextRow<height && nextCol<width){
                if(graph[nextRow][nextCol]==0){
                    queue.push({nextRow, nextCol});
                    graph[nextRow][nextCol]=2;
                }

            }
        }

    }
    int zoneCount=0;
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            if(!graph[i][j]) zoneCount++;
        }
    }
    answer=max(answer,zoneCount);

}

void createWall(vector<vector<int>> graph, int row, int col, int count){
    graph[row][col]=1;
    if(count==0){
        bfs(graph);
        return;
    }
    else{
        for(int i=row; i<height; i++){
            for(int j=0; j<width; j++){
                if(!graph[i][j]) createWall(graph, i,j,count-1);
            }
        }
    }

}

int main(){
    

    cin>>height>>width;
    vector<vector<int>> graph(height, vector<int>(width));
    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            cin>>graph[i][j];
        }
    }    

    for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
            if(!graph[i][j]){
                createWall(graph,i,j,2);
            }

        }
    }

    cout<<answer<<"\n";

    return 0;
}