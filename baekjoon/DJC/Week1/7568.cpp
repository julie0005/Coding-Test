#include <iostream>

using namespace std;

typedef struct{
    int height;
    int weight;
    int more=1;
}Person;

int main(){

    int n;
    Person persons[50];

    cin>>n;
    for(int i=0; i<n; i++){
        cin>>persons[i].height>>persons[i].weight;
    }
    for(int i=0; i<n-1; i++){

        for(int j=i+1; j<n;j++){
            if(persons[i].height<persons[j].height && persons[i].weight<persons[j].weight){
                persons[i].more+=1;
            }
            else if(persons[i].height>persons[j].height && persons[i].weight>persons[j].weight){
                persons[j].more+=1;
            }

        }
    }
    for(int i=0; i<n; i++){
        cout<<persons[i].more<<' ';
    }
}