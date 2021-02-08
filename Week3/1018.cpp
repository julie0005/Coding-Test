#include <iostream>
using namespace std;
int main(){
    int m,n;
    int count;
    int ans=2500;
    cin>>m>>n;
    char list[51][51];
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            cin>>list[i][j];

        }

    }


    for(int i=0; i<m-7; i++){
        for(int j=0; j<n-7; j++){
             count=0;
            for(int k=i; k<i+8; k++){
                for(int l=j; l<j+8; l++){
                    if((k-i)%2==0){
                        if((l-j)%2==0 && list[k][l]!='W'){
                            count++;
                        }
                        else if((l-j)%2==1 && list[k][l]!='B'){
                            count++;
                        }
                    }
                    else{
                        if((l-j)%2==0 && list[k][l]!='B'){
                            count++;
                        }
                        else if((l-j)%2==1 && list[k][l]!='W'){
                            count++;
                        }
                    }

                }

            }
            count= (count>64-count?64-count:count);
            ans=(ans>count?count:ans);
        }

    }
    cout<<ans<<'\n';
    return 0;
}