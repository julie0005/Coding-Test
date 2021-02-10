#include <iostream>
using namespace std;
static int board[9][9]={0};
static int currentRow, currentCol;
static bool stop=false;

bool checkSquare(int limita, int limitb, int num){
    for(int i=limita-3; i<limita; i++){
        for(int j=limitb-3; j<limitb; j++){
            if(board[i][j]==num) return false;
        }
    }
    return true;
}

bool isValid(int num, int x, int y){
    //가로 세로
    for(int i=0; i<9; i++){
        if(board[i][y]==num || board[x][i]==num)
        return false;
    }
    //3*3 사각형
    if(x<3){
        if(y<3){
            if(!checkSquare(3,3,num)) return false;
        }
        else if(y<6){
            if(!checkSquare(3,6,num)) return false;
        }
        else if(y<9){
            if(!checkSquare(3,9,num)) return false;
        }
    }
    else if(x<6){
        if(y<3){
            if(!checkSquare(6,3,num)) return false;
        }
        else if(y<6){
            if(!checkSquare(6,6,num)) return false;
        }
        else if(y<9){
            if(!checkSquare(6,9,num)) return false;
        }
    }
    else if(x<9){
        if(y<3){
            if(!checkSquare(9,3,num)) return false;
        }
        else if(y<6){
            if(!checkSquare(9,6,num)) return false;
        }
        else if(y<9){
            if(!checkSquare(9,9,num)) return false;
        }
    }
    return true;
}

bool findEmpty(){
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            if(board[i][j]==0){
                currentRow=i;
                currentCol=j;
                return true;
            }
        }
    }
    return false;
}


bool fill(){
    int x=0;
    int y=0;

    if(!findEmpty()){
        return true;
    }

    x=currentRow;
    y=currentCol;

    for(int i=1; i<=9; i++){

        if(isValid(i,x,y)){
            board[x][y]=i;
            if(fill()) return true;
            board[x][y]=0;
        }
    }
    return false;
}



int main(){
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    for(int i=0; i<9; i++){
        for(int j=0 ; j<9 ; j++){
            cin>>board[i][j];
        }
    }
    cout<<"\n\n";
    fill();
    for(int i=0; i<9; i++){
        for(int j=0 ; j<9 ; j++){
           cout<<board[i][j]<<' ';
        }
        cout<<'\n';
    }


    return 0;
}