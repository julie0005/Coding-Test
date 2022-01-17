/*
단지번호 붙이기
1. 재귀 dfs로 풀었음. 정렬 대신 priority queue 이용.

*/

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

const int MAX=25;
int SIZE;
int graph[MAX][MAX];
bool visited[MAX][MAX]={false};
int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};

void dfs(int row, int col, int* houseCount){
    visited[row][col]=true;
    (*houseCount)++;
    for(int i=0; i<4; i++){
        int nextRow=row+dRow[i];
        int nextCol=col+dCol[i];
        if(nextRow>=0 && nextCol>=0 && nextRow<SIZE && nextCol<SIZE){
            if(graph[nextRow][nextCol] && !visited[nextRow][nextCol])
            dfs(nextRow, nextCol, houseCount);

        }

    }


}



int main(){

    cin>>SIZE;
    cin.ignore();
    string oneline;
   
    priority_queue<int, vector<int>,greater<int>> houses;
    for(int i=0; i<SIZE; i++){
        getline(cin, oneline);
        for(int j=0; j<SIZE; j++){
            graph[i][j]=oneline[j]-'0';
        }
    }
    
    for(int i=0; i<SIZE; i++){
        for(int j=0; j<SIZE; j++){
            if(graph[i][j] && !visited[i][j]){
                int houseCount=0;
                dfs(i,j,&houseCount);
                houses.push(houseCount);
            }
        }
    }

    cout<<houses.size()<<"\n";
    while(!houses.empty()){
        cout<<houses.top()<<"\n";
        houses.pop();
    }

    return 0;
}