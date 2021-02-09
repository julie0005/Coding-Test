#include <iostream>
#include <queue>
#include <functional>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    priority_queue<int, vector<int>, greater<int>> pq;
    int num,x;
    cin>>num;
    for(int i=0; i<num; i++){

        cin>>x;
        if(x>=1){
            pq.push(x);
        }
        else{
            if(!pq.empty()){
                cout<<pq.top()<<'\n';
                pq.pop();
            }
            else{
                cout<<0<<'\n';
            }
        }

    }
    return 0;
}