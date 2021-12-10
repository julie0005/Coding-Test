/*
 기능 개발
 1. count 초기화
 2. progresses만 pop하고 speed는 pop하지 않았었음.
*/
#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int count=0;
    while(progresses.size()!=0){
        count=0;
        bool flag=true;
        for(int i=0; i<progresses.size(); i++){
            progresses[i]+=speeds[i];
        } 
        for(int i=0; i<progresses.size(); i++){
            if(flag && progresses[i]>=100){ 
                count++;
            }
            else{
                flag=false;
                break;
            }
        }
        if(count>0) answer.push_back(count);
        progresses.erase(progresses.begin(),progresses.begin()+count);
        speeds.erase(speeds.begin(),speeds.begin()+count);
    }
    return answer;
}