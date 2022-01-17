#include <iostream>
using namespace std;
int main(){
    int num, length;
    int sum=0;

    cin>>num>>length;
    char list[1001][51];
    char ans[51];
    int dnaFrequency[4]={0}; //A-C-G-T
    int max;
    int maxindex;
    for(int i=0; i<num; i++){
        for(int j=0; j<length; j++){
            cin>>list[i][j];
        }
    }

    for(int j=0; j<length;j++){
        for(int i=0; i<4; i++){
            dnaFrequency[i]=0;
        }

        for(int i=0; i<num; i++){
            if(list[i][j]=='A'){
                dnaFrequency[0]++;
            }
            else if(list[i][j]=='C'){
                dnaFrequency[1]++;
            }
            else if(list[i][j]=='G'){
                dnaFrequency[2]++;
            }
            else{
                dnaFrequency[3]++;
            }
        }
        max=dnaFrequency[0];
        maxindex=0;
        for(int i=1; i<4; i++){
            if(max<dnaFrequency[i]){
                max=dnaFrequency[i];
                maxindex=i;
            }
        }
        switch(maxindex){
            case 0: ans[j]='A';
                break;
            case 1: ans[j]='C';
                break;
            case 2: ans[j]='G';
                break;
            case 3: ans[j]='T';
                break;

        }

    }
    
    for(int j=0; j<length; j++){
        cout<<ans[j];
        for(int i=0; i<num; i++){
            if(list[i][j]!=ans[j]){
                sum++;
            }
        }
    }
    cout<<'\n'<<sum<<'\n';
    return 0;
}