#include <iostream>
using namespace std;
int main(){
    int n,m;
    int list[100];
    int sum=0;
    int ans=0;
    cin>>n>>m;
    for(int i=0; i<n; i++){
        cin>>list[i];
    }
    for(int i=0; i<n-2; i++){
        for(int j=i+1;j<n-1 ;j++){
            for(int k=j+1; k<n; k++){
                sum=list[i]+list[j]+list[k];
                if(abs(ans-m)>abs(sum-m) && sum<=m){
                    ans=sum;
                }
            }

        }


    }

    cout<<ans;

    return 0;
}