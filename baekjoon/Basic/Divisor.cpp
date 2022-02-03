/*1037 약수
어떤 수는 약수들의 최소공배수.
=> 어떤 수들의 최소공배수 구하는 법.
포인트
// 1. 최소공배수 알고리즘
// 2. 최대공약수 알고리즘
// 3. a*b=gcd(a,b)*lcm(a,b) => 오버플로우
// 4. 정렬 후 가장 작은 값과 큰 값 곱하기
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

//두 수의 최대공약수
long long gcd(long long a, long long b){
    long long c;
    while(b!=0){
        c=a%b;
        a=b;
        b=c;
    }
    return a;

    //or return a%b==0 ? b : gcd(b, a%b);
}

//두 수의 최소공배수
long long lcm(long long a, long long b){
    return a*b/gcd(a,b);
}

// n개의 최소공배수
int main(){
    int divisor_num;
    vector<int> divisors;

    cin>>divisor_num;
    for(int i=0; i<divisor_num; i++){
        int divisor;
        cin>>divisor;
        divisors.push_back(divisor);
    }
    long long answer;
    sort(divisors.begin(),  divisors.end());
    answer=divisors[0]*divisors[divisors.size()-1];
    cout<<answer<<'\n';
    

}