/*
안전영역 구하기
**주의 : 최저와 최고 범위가 주어졌네, 이 범위에서 돌려야겠다. (X) => 빗물의 높이 정보에 대한 제한은 주어지지 않았음. 그 말은 즉슨, 최저, 최대 어느 정도로 줄지 모른다는 뜻.
빗물 높이는 1이상이란 말은, 지역이 감당할 수 있는 빗물 높이.
안 올 수도 있으니 최저는 0부터. minHeight=0
*/

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int SIZE;
const int MAX=100;
int graph[MAX][MAX];
bool visited[MAX][MAX]={false};
int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};
int currentHeight;
void dfs(int row, int col){
    visited[row][col]=true;
    for(int i=0; i<4; i++){
        int nextRow=row+dRow[i];
        int nextCol=col+dCol[i];
        if(nextRow>=0 && nextCol>=0 && nextRow<SIZE && nextCol<SIZE){
            if(graph[nextRow][nextCol]>currentHeight && !visited[nextRow][nextCol]){
                dfs(nextRow,nextCol);
            }
        }
    }
}

int main(){
    
    
    int maxHeight=1;
    priority_queue<int, vector<int>> answers;
    cin>>SIZE;
    for(int i=0; i<SIZE; i++){
        for(int j=0; j<SIZE; j++){
            cin>>graph[i][j];
            if(maxHeight<graph[i][j]){
                maxHeight=graph[i][j];
            }
        }
    }

    for(int height=0; height<=maxHeight; height++){
        for(int m=0; m<SIZE; m++){
            for(int n=0; n<SIZE; n++){
                visited[m][n]=false;
            }
        }
        int safeCount=0;
        currentHeight=height;

        for(int m=0; m<SIZE; m++){
            for(int n=0; n<SIZE; n++){
                if(graph[m][n]>height && !visited[m][n]){
                    safeCount++;
                    dfs(m,n);
                }
            }
        }
        answers.push(safeCount);
    }
    cout<<answers.top()<<"\n";
    return 0;

}