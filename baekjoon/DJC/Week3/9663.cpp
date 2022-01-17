#include <iostream>
using namespace std;
// N-Queen 문제
// N개의 Queen이 NxN 체스판에서 서로 공격할 수 없게 놓이는 경우의 수를 구하는 것.
// 열마다 한개의 퀸을 둔다는 발상으로 시작.
static int board[15][15]={0};
static int cnt=0;
//Promising
bool isValid(int n, int x, int y){
    //N개가 [x][y] 위치에서 유효한가?
    
    //가로 세로
    for(int i=0; i<n; i++){
        if(board[x][i]==1 || board[i][y]==1){
            
            return false;
        }
    }
    //대각선
    for(int i=1; i<n; i++){

        if(x-i>=0 && x-i<n){
            if(y-i>=0 && y-i<n){
                if(board[x-i][y-i]==1){
                    
                    return false;
                }
            }
            if(y+i>=0 && y+i<n){
                if(board[x-i][y+i]==1){
                    
                    return false;
                }
            }
        }
        if(x+i>=0 && x+i<n){
            if(y-i>=0 && y-i<n){
                if(board[x+i][y-i]==1){
                    
                    return false;
                }
            }
            if(y+i>=0 && y+i<n){
                if(board[x+i][y+i]==1){
                    
                    return false;
                }
            }
        }
    }
    return true;

}

bool fill(int n, int row, int col){
    int x=row;
    int y=col;
    
    for(int i=x; i<n; i++){
        
        if(isValid(n,i,y)){
            board[i][y]=1;
            if(y==n-1){ // 체스판에 퀸이 n개 놓은 경우.
                cnt++;
                board[i][y]=0; //backtracking으로 다시 지우기
                return true; //return으로 그만 탐색하기. 해를 발견했으니 이후는 무의미한 탐색이다.
            }
            fill(n, 0, y+1);
            board[i][y]=0;
        }

    }
    return false;
}

int main(){
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    int n;

    cin>>n;
    
    fill(n,0,0);
    
    cout<<cnt<<'\n';
    return 0;
}