#include <iostream>
using namespace std;

int main(){

    int n,m,cnt=0;
    int ans=2500;
    char board[50][50]={'\0'};
    cin>>n>>m;
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            cin>>board[i][j];
        }
    }
    //왼쪽 위 black이라 가정

    for(int i=0; i<n-7; i++){
        for(int j=0; j<m-7; j++){
            cnt=0;
            for(int k=i; k<i+8; k++){
                for(int l=j; l<j+8; l++){
                    if((k-i)%2==0){
                        if((l-j)%2==0 && board[k][l]!='B'){
                            cnt++;
                        }
                        else if((l-j)%2==1 && board[k][l]!='W'){
                            cnt++;
                        }
                       
                    }
                    else if((k-i)%2==1){
                        if((l-j)%2==0 && board[k][l]!='W'){
                            cnt++;
                        }
                        else if((l-j)%2==1 && board[k][l]!='B'){
                            cnt++;
                        }
                       
                    }
                    
                }

            }
            cnt= (cnt<=64-cnt) ? cnt : (64-cnt); 
            
            if(cnt<=ans) ans=cnt;
        }

    }

    cout<<ans;

    return 0;
}