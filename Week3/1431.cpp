#include <iostream>
#include <algorithm>
#include <string>
using namespace std;
//-'0'이 필요한 이유: 11 / 3 -> 49*2=98 / 50 일케됨.
bool compare(string a, string b){
    if(a.length()!=b.length()) return a.length()<b.length();
    else{
        int sum1=0, sum2=0;
        for(int i=0; i<a.length(); i++){
            if(a[i]>='0' && a[i]<='9'){
                sum1+=a[i]-'0';
            }
        }
        for(int i=0; i<b.length(); i++){
            if(b[i]>='0' && b[i]<='9'){
                sum2+=b[i]-'0';
            }
        }
    
        if(sum1!=sum2) return sum1<sum2;
        else return a<b;
    }
   

}

int main(){

    int n;
    string list[1000];
    cin>>n;
    for(int i=0; i<n; i++){
        cin>>list[i];
    }

    sort(list,list+n, compare);
    for(int i=0; i<n; i++){
        cout<<list[i]<<'\n';
    }

    return 0;
}