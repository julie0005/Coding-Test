#include <iostream>
#include <deque>
#include <algorithm>
#include <vector>
using namespace std;
int main(){
    int n,m;
    deque<int> position;
    deque<int> queue;
    int temp;
    int target;
    int count=0;
    cin>>n>>m;
    for(int i=0; i<n; i++){
        queue.push_back(i+1);
    }
    for(int i=0; i<m; i++){
        cin>>temp;
       position.push_back(temp);
    }
    while(!position.empty() && !queue.empty()){
        target=position.front();
        int posIndex;
        for(int i=0; i<queue.size(); i++){
            if(queue[i]==target) posIndex=i;   
        }
        if(queue.front()!=target){
            if(queue.size()-posIndex-1<posIndex){
                for(int i=0; i<queue.size()-posIndex; i++){
                    int top=queue.back();
                    queue.pop_back();
                    queue.push_front(top);
                }
                count+=queue.size()-posIndex;
            }
            else if(queue.size()-posIndex-1>=posIndex){
                for(int i=0; i<posIndex; i++){
                    int top=queue.front();
                    queue.pop_front();
                    queue.push_back(top);
                }
                count+=posIndex;
            }
        }
        
        if(queue.front()==target){
            queue.pop_front();
            position.pop_front();
        }
    }
    cout<<count<<'\n';
    
    return 0;
}