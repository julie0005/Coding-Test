#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main(){

    
    int n, divider,sum=0, remain,a;
    cin>>n;
    int *list=new int[n+1]{0};
    int max;
    string temp;
    for(int i=1; i<n+1; i++){
        sum=0;
        a=i;
        max=to_string(a).length()-1;
        divider=pow(10,max);
        do{
            sum+=a/divider;
            remain=a%divider;
            a=remain;
            divider=divider/10;
        }while(remain!=0);
        sum+=i;
        if(sum<=n && list[sum]==0){
            list[sum]=i;
        }
    }
    
    cout<<list[n]<<endl;
    delete[] list;
    return 0;
}