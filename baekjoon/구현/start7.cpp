/* 2444 별 찍기 - 7

*/

#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int N;
    cin>>N;
    for(int i=0; i<2*N-1; i++){
        int starNumCof=i<N ? i : 2*(N-1)-i;
        for(int j=0; j<(int)abs(N-i-1); j++){
            cout<<' ';
        }
        for(int j=0; j<2*starNumCof+1; j++) cout<<'*';
        
        cout<<'\n';
    }
}
