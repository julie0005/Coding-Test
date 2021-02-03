#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

int main(){

    
    int n, divider,sum=0, remain,a;
    cin>>n;
    vector<int> vec1(n+1,0);
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
        if(sum<=n && vec1[sum]==0){
            vec1[sum]=i;
        }
    }
    
    cout<<vec1[n]<<endl;
    return 0;
}