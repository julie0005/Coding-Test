/*2562 최댓값*/

#include <iostream>
#include <vector>

using namespace std;

vector<int> input;

int main(){
    int curMax=0;
    int maxOrder=-1;
    for(int i=0; i<9; i++){
        int curNum;
        cin>>curNum;
        if(curMax<curNum) {
            curMax=curNum;
            maxOrder=i+1;
        }
    }
    cout<<curMax<<'\n'<<maxOrder;
}