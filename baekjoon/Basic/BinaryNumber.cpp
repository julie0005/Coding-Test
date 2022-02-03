/* 3460 이진수 
십진수 이진수로 바꾸기.
 testcase별 출력에 개행문자 포함하는 것 잊지말기.
*/
#include <iostream>
#include <vector>
using namespace std;

vector<int> binary_num;

void dec_to_bin(int num){
    int divided=num;
    while(divided!=1){
        binary_num.push_back(divided%2);
        divided=divided/2;
    }
    binary_num.push_back(1);
}

int main(){
    int testcase;

    cin>>testcase;
    for(int i=0; i<testcase; i++){
        binary_num.clear();
        int n;
        cin>>n;
        dec_to_bin(n);
        for(int i=0; i<binary_num.size(); i++){
            if(binary_num[i]==1) {
                cout<<i;
                if(i==binary_num.size()-1) cout<<'\n';
                else cout<<' ';
            }
        }
    }
   
    return 0;
}