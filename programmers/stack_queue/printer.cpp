/*
프린터
1. 중요도가 높은 문서 인쇄한다는 소리 없었는데 나 혼자 비약을 해서 2시간 날림.
2. 문제 그대로 이해할 것.
*/

#include <string>
#include <vector>
#include <iostream>
using namespace std;
int decideOutIndex(vector<int> priorities, int currentPriority){
    int max=currentPriority;
    int maxIndex=0;
    for(int i=0; i<priorities.size(); i++){
        cout<<priorities[i]<<' ';
        if(max<priorities[i]){
            max=priorities[i];
            maxIndex=i;
        }
    }
    cout<<'\n';
    return maxIndex;
}

int solution(vector<int> priorities, int location) {
    int answer = 1;
    int currentIndex=0;
    int currentPriority=priorities.front();
    int targetLocation=location;
    int targetPriority=priorities[location];
    int outIndex=-1;
    
    while(!priorities.empty()){
        currentIndex=0;
        currentPriority=priorities.front();
        outIndex=decideOutIndex(priorities, currentPriority);
        if(outIndex==targetLocation) break;
        if(outIndex!=currentIndex){
            priorities.erase(priorities.begin());
            priorities.push_back(currentPriority);
            if(targetLocation==currentIndex) targetLocation=priorities.size()-1;
            else targetLocation--;
        }
        else{
            priorities.erase(priorities.begin());
            targetLocation--;
            answer++;
        }
    }
    return answer;
}