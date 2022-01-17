/*
2210 숫자판 점프
유사문제 : 단지구하기
상하좌우로 이동하는 것 : 가지수가 4개로 나뉘는 그래프 문제.
보드 시작점 하나하나가 dfs 시작점.
*/
#include <iostream>
#include <vector>
#include <string>
using namespace std;
const int MAX=5;
string board[MAX][MAX];
vector<string> differentNumbers;
//상,하,좌,우
int drow[4]={1,-1,0,0};
int dcol[4]={0,0,1,-1};
void dfs(int currentRow, int currentCol, int depth, string prevString){
    string currentString=prevString+board[currentRow][currentCol]; 
    if(depth==6){
        //differentNumbers에 중복 없는지 확인 후 없으면 push.
        bool isUnique=true;
        for(int i=0; i<differentNumbers.size(); i++){
            if(differentNumbers[i]==currentString){
                isUnique=false;
                break;
            }
        }
        if(isUnique) differentNumbers.push_back(currentString);
        return; //return 안해주면 무한루프에 빠져버림.
    }

    for(int i=0; i<4; i++){
        int nextRow=currentRow+drow[i];
        int nextCol=currentCol+dcol[i];
        if(nextRow<0 || nextRow>=MAX || nextCol<0 || nextCol>=MAX) continue;
        dfs(nextRow,nextCol,depth+1,currentString);
    }

}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for(int i=0; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            cin>>board[i][j];
        }
    }

    for(int i=0; i<MAX; i++){
        for(int j=0; j<MAX; j++){
            dfs(i,j,1,"");
        }
    }
    cout<<differentNumbers.size();

}