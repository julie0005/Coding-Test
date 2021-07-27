/*
여행경로(dfs 풀이)
** 시행착오
1. 가능한 경로 중 알파벳 오름차순 하라 했는데, 고려하지 않고 일단 알파벳 오름차순으로 감. 
=> 해결 : dfs 리턴 값에 따라 잘못된 길로 들어선건지, 올바른건지 판별. 아직 모든 노드를 방문하지 않았는데 갈 곳이 없으면 return 0
2. return 0 되면 다음 sibling 노드를 방문하도록 해서 이후는 return 1이 될 수 밖에 없다고 생각함. => 다음 sibling이 없는 경우를 생각하지 못함.
=> return 0 되었는데, 다음 sibling 없다면(for문의 끝이야.) return 0 하도록.
*/

#include <string>
#include <vector>
#include <algorithm>

using namespace std;
vector<string> answer;
vector<vector<string>> staticTickets;
vector<bool> used;

int dfs(string start){
    answer.push_back(start);
    string arrival="ZZZ";
    int usedCount=0;
    vector<pair<string,int>> candidates;
    for(int i=0; i<staticTickets.size(); i++){
        if(used[i]) usedCount++;
        if(start==staticTickets[i][0] && !used[i]){
            candidates.push_back(pair<string,int>(staticTickets[i][1],i));
        }
    }
    if(candidates.empty()){
        if(usedCount==staticTickets.size()) return 1;
        else
        {  
            answer.pop_back();
            return 0;
        }
    }
    sort(candidates.begin(), candidates.end());
    for(int i=0; i<candidates.size(); i++){
        used[candidates[i].second]=true;
        if(!dfs(candidates[i].first)){
            used[candidates[i].second]=false;
            if(i==candidates.size()-1){ answer.pop_back(); return 0;} // 이걸로 (2) 막음.
        }
        else break;
    }
    //다 순회하고 여기 도달한 경우가 정상적인 경우 말고는 없을 줄 알았는데,
    // candidates에 비정상적인 마지막 leaf 말고 없어도 일로 오게됨. (2)
    return 1;
}
vector<string> solution(vector<vector<string>> tickets) {
    staticTickets=tickets;
    for(int i=0; i<tickets.size(); i++){
        used.push_back(false);
    }
    dfs("ICN");
    
    return answer;
}