#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main(){
    string word2="dot";
    string word="hot";
    word.erase(remove(word.begin(), word.end(), word2[1]),word.end());
    cout<<word<<endl<<word.length()<<'\n';
    string word3="hto";
    if(word3.find(word)!=string::npos)
        cout<<"yes";
}