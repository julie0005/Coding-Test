#include <string>
#include<iostream>
#include <vector>
#include <regex>

using namespace std;

string replaceToSmallLetter(string new_id){
    int diff='A'-'a';
    for(int i=0; i<new_id.size(); i++){
        if(new_id[i]>='A' and new_id[i]<='Z') new_id[i]=new_id[i]-diff;
    }
    return new_id;
}

string eraseUnvalidLetter(string new_id){
    regex re("[^a-z0-9\\-\\_\\.]");
    new_id=regex_replace(new_id,re,"");
    return new_id;
}

string replaceToOnePeriod(string new_id){
    regex re("\\.{2,}");
    new_id=regex_replace(new_id,re,".");
    return new_id;
}

string eraseUnvalidPeriod(string new_id){
    if(new_id[0]=='.') new_id.erase(0,1);
    if(new_id[new_id.size()-1]=='.') new_id.erase(new_id.size()-1);
    return new_id;
}

string solution(string new_id) {
    string answer = "";
    new_id=replaceToSmallLetter(new_id);
    new_id=eraseUnvalidLetter(new_id);
    new_id=replaceToOnePeriod(new_id);
    new_id=eraseUnvalidPeriod(new_id);
    if(new_id=="") new_id.append("a");
    if(new_id.size()>=16) new_id=new_id.substr(0,15);
    new_id=eraseUnvalidPeriod(new_id);
    if(new_id.size()<=2){
        while(new_id.size()<3){
            new_id.append(1,new_id[new_id.size()-1]);
        }
    }
    answer=new_id;
    return answer;
}