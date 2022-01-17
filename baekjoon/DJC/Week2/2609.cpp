#include <iostream>
using namespace std;

int main(){
    int a,b;
    cin>>a>>b;
    int max=0;
    for(int i=1; i<=a; i++){
        if(a%i==0 && b%i==0 && i>max){
            max=i;
        }
    }
    int min=max*(a/max)*(b/max);
    cout<<max<<'\n'<<min<<'\n';
    return 0;
}