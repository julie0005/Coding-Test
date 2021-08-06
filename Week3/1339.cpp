/*
단어수학
/** 2차원 벡터로도 해보기.
*/
#include <iostream>
#include <vector>
using namespace std;

char wordBoard[11][9];

void dfs(){

}

int main(){
    int num;
    string oneline;
    vector<char> alphabets;
    cin>>num;
    cin.ignore();
    for(int i=0; i<num; i++){
        getline(cin, oneline);
        for(int j=0; j<oneline.length(); j++){
            wordBoard[i][j]=oneline[j];
        }
        wordBoard[i][oneline.length()]='\0';
    }

    for(int i=0; i<num; i++){
        for(int j=0; wordBoard[i][j]!='\0';j++){
            bool isUnique=true;
            for(int k=0; k<alphabets.size(); k++){
                if(wordBoard[i][j]==alphabets[k]) isUnique=false;
            }
            if(isUnique) alphabets.push_back(wordBoard[i][j]);
        }
    }

    

    return 0;
}