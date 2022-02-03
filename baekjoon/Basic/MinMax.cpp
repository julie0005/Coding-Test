/* 10818 최소, 최대 */

#include <iostream>

using namespace std;

int main(){
    int num;
    int min=1000000,max=-1000000;
    
    cin>>num;
    for(int i=0; i<num; i++){
        int integer;
        cin>>integer;
        if(min>integer) min=integer;
        if(max<integer) max=integer;
    }
    cout<<min<<' '<<max;

    return 0;
}