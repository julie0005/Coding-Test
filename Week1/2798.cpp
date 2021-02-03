#include <iostream>
using namespace std;
int main(){
    
    int n,m;
    int list[100];
    int temp1, temp2, temp3;
    int sum=0, result;
    cin>>n>>m;
    int pastD=m;
    for(int i=0; i<n; i++){
        cin>>list[i];
    }
    for(int i=0; i<n-2; i++){
        temp1=list[i];
        for(int j=i+1; j<n-1; j++){
            temp2=list[j];
            for(int k=j+1; k<n;k++){
                temp3=list[k];
                sum=temp1+temp2+temp3;
                if(abs(sum-m)<pastD && sum<=m){
                    pastD=abs(sum-m);
                    result=sum;
                }
            }

        }

    }

    cout<<result<<endl;

    return 0;
}