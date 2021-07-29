/*
미로 탐색
깊이 중에서 최소 깊이. => bfs로 하면 정렬할 필요도 없음.
dfs 중에 깊이가 끝없이 이어지는 그런게 있다면 빠르게 bfs.
c++ 공백 없이 숫자 한줄로 들어올 때 한글자씩 입력받는 방법.
1. scanf("%1d", &graph[i][j]);
2. getline으로 1줄씩 받은 후, 쪼개서 넣기.

**주의 : bfs 시, queue에 넣자마자 visited 체크해주지 않으면 여러번 들어가게 됨.
예를 들어, sibling들이 4개가 들어가게 되었음. pop한다음에 visited한다고 치자.
그럼 가장 먼저 들어간 녀석의 nextRow와 nextCol을 계산해주었는데 최근에 들어온 녀석이랑 인덱스가 같아.
근데 최근에 들어온 녀석은 아직 pop 안되었으니 visited 되지 않았어. 그럼 여러번 들어가게 되는거지.
*/

#include <iostream>
#include <queue>
using namespace std;

int height, width;
int dRow[4]={-1,1,0,0};
int dCol[4]={0,0,-1,1};
int answer=0;

typedef struct{
    int row;
    int col;
    int depth;
}place;

void bfs(int row, int col, int depth, vector<vector<int>> &graph, vector<vector<bool>> &visited){
    queue<place> queue;
    queue.push({row, col, depth});
    visited[row][col]=true;
    while(!queue.empty()){
        row=queue.front().row;
        col=queue.front().col;
        depth=queue.front().depth;
        queue.pop();
        
        for(int i=0; i<4; i++){
            int nextRow=row+dRow[i];
            int nextCol=col+dCol[i];
            if(nextRow>=0 && nextRow<height && nextCol>=0 && nextCol<width){
                if(nextRow==height-1 && nextCol==width-1){
                    answer=depth+1;
                    return;
                }
                if(!visited[nextRow][nextCol] && graph[nextRow][nextCol]){
                    queue.push({nextRow, nextCol, depth+1});
                    visited[nextRow][nextCol]=true;
                }
            }
        }

    }

}

int main(){
    string oneline;
    cin>>height>>width;
    cin.ignore();
    vector<vector<int>> graph(height, vector<int>(width,0));
    vector<vector<bool>> visited(height, vector<bool>(width, false));
    for(int i=0; i<height; i++){
        
        getline(cin,oneline);
        for(int j=0; j<width; j++){
            //scanf("%1d", &graph[i][j]);
            graph[i][j]=oneline[j]-'0';
        }
        
    }
    bfs(0,0,1,graph, visited);
    
    cout<<answer<<"\n";
    return 0;
}