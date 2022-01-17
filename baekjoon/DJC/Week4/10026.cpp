/*
적록색맹
**주의 : greenRedSame bool 같은 변수 반대로 헷갈리지 말기
그 외는 EZ였음.~ ^^.
*/
#include <iostream>
using namespace std;

const int MAX=100;
int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};
char graph[MAX+1][MAX+1];
bool visited[MAX][MAX]={false};
int SIZE;

void dfs(int row, int col, bool greenRedSame){

    visited[row][col]=true;
    for(int i=0; i<4; i++){
        int nextRow=row+dRow[i];
        int nextCol=col+dCol[i];
        if(nextRow>=0 && nextCol>=0 && nextRow<SIZE && nextCol<SIZE){
            if(visited[nextRow][nextCol]) continue;
            if(!greenRedSame){
                if(graph[row][col]==graph[nextRow][nextCol])
                {
                    dfs(nextRow, nextCol, greenRedSame);
                }
            }
            else{
                bool greenRedCase=(graph[row][col]=='R' || graph[row][col]=='G');
                bool isNextGRCase=(graph[nextRow][nextCol]=='R' || graph[nextRow][nextCol]=='G');
                bool isNextSame=(graph[row][col]==graph[nextRow][nextCol]);
                if((greenRedCase && isNextGRCase) || isNextSame) dfs(nextRow, nextCol, greenRedSame);
            }

        }
    }

}


int main(){

    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string oneline;
    int normalAreaCount=0;
    int abnoremalAreaCount=0;

    cin>>SIZE;
    cin.ignore();
    for(int i=0; i<SIZE; i++){
        getline(cin, oneline);
        for(int j=0; j<SIZE; j++){
            graph[i][j]=oneline[j];
        }
    }

    for(int i=0; i<SIZE; i++){
        for(int j=0; j<SIZE; j++){
            if(!visited[i][j]){
                normalAreaCount++;
                dfs(i,j,false);
            }
        }
    }

    for(int i=0; i<SIZE; i++){
        for(int j=0; j<SIZE; j++){
            visited[i][j]=false;
        }
    }
    
    for(int i=0; i<SIZE; i++){
        for(int j=0; j<SIZE; j++){
            if(!visited[i][j]){
                abnoremalAreaCount++;
                dfs(i,j,true);
            }
        }
    }

    cout<<normalAreaCount<<" "<<abnoremalAreaCount<<"\n";
    return 0;
}