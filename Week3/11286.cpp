#include <iostream>
#include <queue>

using namespace std;

struct compare{
    bool operator()(int a, int b){
        if(abs(a)!=abs(b)) return abs(a)>abs(b);
        return a>b;
    }

};

int main(){
    cin.tie(NULL);
    cout.tie(NULL);
    ios_base::sync_with_stdio(false);
    priority_queue<int, vector<int>, compare> pq;
    int num,x;
    cin>>num;
    for(int i=0; i<num; i++){
        cin>>x;
        if(x!=0){
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


}