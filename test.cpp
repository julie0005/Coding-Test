#include <iostream>
#include <vector>

using namespace std;

int main(){
    vector<int> numbers;
    int n=5;
    for(int i=0; i<n; i++){
        int elem;
        cin>>elem;
        numbers.push_back(elem);
    }
    cout<<numbers.size();

}