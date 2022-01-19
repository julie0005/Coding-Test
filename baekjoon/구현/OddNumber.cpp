/*2576 홀수*/

#include <iostream>
#include <vector>
using namespace std;


int main(){

    int odd_sum=0;
    int odd_min=100;
    for(int i=0; i<7; i++){
        int num;
        cin>>num;
        if(num%2==1){
            odd_sum+=num;
            if(odd_min>num) odd_min=num;
        }
        
    }
    odd_sum==0 ? cout<<-1 : cout<<odd_sum<<'\n'<<odd_min;
    

    return 0;
}