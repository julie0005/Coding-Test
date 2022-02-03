/*10872 팩토리얼*/

#include <iostream>

using namespace std;

long long factorial(int num){
    if(num==1) return num; 
    else if(num==0) return 1;
    else return num*factorial(num-1);
}

int main(){
    int N;
    cin>>N;
    cout<<factorial(N);

}