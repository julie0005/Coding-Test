/* 5598 카이사르 암호 */

#include <iostream>
#include <string>
using namespace std;

int main(){
    string input;
    cin>>input;
    int diff='D'-'A';
    for(int i=0; i<input.length(); i++){
        char output;
        output=input[i]>'C' ? (char)(input[i]-diff) : (char)(input[i]-diff+26);
        cout<<output;
    }
    cout<<'\n';
}