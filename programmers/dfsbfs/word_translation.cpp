/*
단어 변환
단어 알파벳 중에 한개씩 바꿔서 target에 도달하는 문제.
**주의 : vector<string>을 다룰 때 string의 원소에 접근하고 싶다면 [i][j] 이렇게 2차원 배열처럼 접근하는 것 주의.
target이 순회하는 배열들 안에 있을 때는 visited를 잘 관리해줘야 함.
*/

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
vector<string> graph;
vector<int> stages;
bool visited[52]={false};
string staticTarget;
int targetIndex;
void dfs(string word, int depth, int index){
   
    if(index!=-1){
        visited[index]=true;
    }
    if(word==staticTarget){
        stages.push_back(depth);
        visited[targetIndex]=false; //dfs리턴된 뒤, 다시 target 찾았을 때를 위함. 이런 경우를 방지하려면 target 찾은거를 dfs 들어가기 전에 해줘야.
        return;
    }
    for(int i=0; i<word.length(); i++){
        for(int j=0; j<graph.size(); j++){
            int sameCount=0;
            for(int k=0; k<graph[j].length(); k++){
                if(graph[j][k]==word[k]) sameCount++;
            }
            if(sameCount==word.length()-1 && !visited[j]){
                dfs(graph[j], depth+1, j);
            }
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    staticTarget=target;
    graph=words;
    for(int i=0; i<words.size(); i++){
        if(target==words[i]) targetIndex=i;
    }
    dfs(begin,0,-1);
    int answer=1000;
    if(stages.empty()) answer=0;
    for(int i=0; i<stages.size(); i++){
        if(answer>stages[i]){
            answer=stages[i];
        }
    }
    return answer;
}