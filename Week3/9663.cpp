#include <iostream>
using namespace std;

static int board[15][15]={0};
static int cnt=0;
//Promising
bool isValid(int n, int x, int y){
    
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
                board[i][y]=0;
                return true;
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