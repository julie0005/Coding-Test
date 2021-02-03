#include <iostream>
using namespace std;
int main(){

    int balance,cnt=0;
    cin>>balance;
    balance=1000-balance;
    while(balance!=0){

        if(balance>=500){
            balance-=500;
        }
        else if(balance>=100){
            balance-=100;
        }
        else if(balance>=50){
            balance-=50;
        }
        else if(balance>=10){
            balance-=10;
        }
        else if(balance>=5){
            balance-=5;
        }
        else{
            balance-=1;
        }
        cnt++;
    }

    cout<<cnt;

    return 0;
}