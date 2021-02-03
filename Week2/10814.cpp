#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

//sort or stable_sort
class Coordinate{
public:
    string name;
    int age;
    int index;
    Coordinate(string name, int age, int index){
        this->name=name;
        this->age=age;
        this->index=index;
    }
};

bool compare(Coordinate a, Coordinate b){
    if(a.age!=b.age){
        return a.age < b.age;
    }
    return a.index<b.index;
}

int main(){
    int n;
    vector<Coordinate> list;
    cin>>n;
    int age;
    string name;
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    for(int i=0; i<n; i++){
        cin>>age>>name;
        list.push_back(Coordinate(name,age,i));
    }
    sort(list.begin(), list.end(),compare);
    for(int i=0; i<n; i++){
        cout<<list[i].age<<' '<<list[i].name<<'\n';
    }

}