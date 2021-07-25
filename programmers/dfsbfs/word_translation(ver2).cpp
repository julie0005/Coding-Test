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
    
    for(int i=0; i<word.length(); i++){
        for(int j=0; j<graph.size(); j++){
            int sameCount=0;
            for(int k=0; k<graph[j].length(); k++){
                if(graph[j][k]==word[k]) sameCount++;
            }
            if(sameCount==word.length()-1){
                if(graph[j]==staticTarget){
                    stages.push_back(depth+1);
                    continue;
                }
                else if(!visited[j]){
                    dfs(graph[j], depth+1, j);
                }
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