#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <iostream>
using namespace std;

int main(){
    string oneline;
    int height,width;
    cin>>height>>width;
    cin.ignore();
    for(int i=0; i<4; i++){
        getline(cin, oneline);  
    cout<<oneline<<endl;
        for(int j=0; j<6; j++){
            cout<<oneline[j]-'0'<<endl;
        }
    }
    
}