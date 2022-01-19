/* 10809 알파벳 찾기 */

#include <iostream>
#include <cstring>

using namespace std;

int main(){
    string S;
    cin>>S;
    for(char alphabet='a'; alphabet<='z'; alphabet++){
        int idx=S.find(alphabet);
        if(idx==string::npos) cout<<-1;
        else{
            cout<<idx;
        }
        cout<<' ';
    }

    return 0;
}