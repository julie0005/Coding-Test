/*
유기농 배추
"testcase에 대해 connected graph 개수 구해보렴"
**다시 풀어볼 때 : x,y 좌표 그냥 그대로 해보기, bfs로 풀어보기.
**주의 : testcase를 줄 때는 초기화에 특히 주의하자. 테스트케이스가 바뀔 때마다 초기화해야하는 변수들 정리할 것.
graph와 visited 모두 초기화 해줘야함.
**height-row-1로 하던, row로 하던 답이 바귀지 않았음. 왜? 어차피 상하대칭된 것이라 좌표에는 영향이 없어서.

*/
#include <iostream>
#include <vector>

using namespace std;
int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};
//상,하,좌,우
int graph[50][50]={0};
bool visited[50][50];
int width, height;
void dfs(int row, int col){
    visited[row][col]=true;
    for(int i=0; i<4; i++){
        int nextRow=row+dRow[i];
        int nextCol=col+dCol[i];
        if(nextRow<0 || nextRow>=height || nextCol<0 || nextCol>=width) continue;
        if(graph[nextRow][nextCol] && !visited[nextRow][nextCol]) dfs(nextRow,nextCol);
    }
}

int main(){
    int testcase, cabbages;
    cin>>testcase;
    for(int i=0; i<testcase;i++){
        cin>>width>>height>>cabbages;
        int row,col;
        int answer=0;
        for(int m=0; m<height; m++){
            for(int n=0; n<width; n++){
                visited[m][n]=false;
                graph[m][n]=0;
            }
        }
        for(int j=0; j<cabbages; j++){
            cin>>col>>row;
            graph[row][col]=1;
        }
        for(int m=0; m<height; m++){
            for(int n=0; n<width; n++){
                if(graph[m][n] && !visited[m][n]){
                    dfs(m,n);
                    answer++;
                }
            }
        }
        cout<<answer<<"\n";
    }

    return 0;
}