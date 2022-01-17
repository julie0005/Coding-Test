/*
나이트 이동하기(다음에 dfs로 풀어보기)
싸이클이 있는 문제인데 최소 depth로 가는 것을 찾기가 매우 어려웠음. 
dfs로 한다는 것은 한 경로를 선택하면 거기 끝장내고 다음 단계로 가는 것인데, 그 과정에서 visited가 다 1이 되버림.
그래서 sibling으로 가서 다시 그 곳을 방문할 수가 없음.
bfs로 하면 최소 깊이에서 target을 만나면 바로 return 하면 됨.
*/

#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int SIZE;
int board[300][300];
int targetRow, targetCol;
int startRow, startCol;
int dRow[8]={-2,-1,1,2,2,1,-1,-2};
int dCol[8]={1,2,2,1,-1,-2,-2,-1};
typedef struct {
    int row;
    int col;
    int depth;
}place;

int bfs(int row, int col, int depth){
    queue<place> queue;
    queue.push({row, col, depth});
    board[row][col]=1;
    while(!queue.empty()){
        row=queue.front().row;
        col=queue.front().col;
        depth=queue.front().depth;
        queue.pop();
        
        for(int i=0; i<8; i++){
            int nextRow=row+dRow[i];
            int nextCol=col+dCol[i];
            if(nextRow>=0 && nextCol>=0 && nextRow<SIZE && nextCol<SIZE){
                if(nextRow==targetRow && nextCol==targetCol){
                    return depth+1;
                }
                if(!board[nextRow][nextCol]){
                    queue.push({nextRow,nextCol,depth+1});
                    board[nextRow][nextCol]=1;
                }
            }
        }
    }
    return 0;
}



int main(){
    int testcase, length;
    cin>>testcase;
    for(int i=0; i<testcase; i++){
        int row, col;
        cin>>length;
        SIZE=length;
        for(int m=0; m<length; m++){
            for(int n=0; n<length; n++){
                board[m][n]=0;
            }
        }
        cin>>startRow>>startCol>>targetRow>>targetCol;
        if(startRow==targetRow && startCol==targetCol){
            cout<<0<<"\n";
        }
        else{
            cout<<bfs(startRow, startCol, 0)<<"\n";
        }
    }

}