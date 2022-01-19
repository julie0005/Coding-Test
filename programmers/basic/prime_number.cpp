/* 프로그래머스 소수 만들기 

1. n개 중에서 m개 포문을 통해 완전탐색 하는 법 : m중 포문
2. 소수인지 판별하는 법
*/

#include <vector>
#include <iostream>
using namespace std;

bool isPrimeNumber(int num){
    for(int i=1; i<=num; i++){
        if(i!=1 and i!=num and num%i ==0) return false;
    }
    return true;
}

int solution(vector<int> nums) {
    int answer = 0;

    for(int i=0; i<=nums.size()-3; i++){
        for(int j=i+1;j<=nums.size()-2; j++){
            for(int k=j+1; k<=nums.size()-1; k++){
                int sum=nums[i]+nums[j]+nums[k];
                if(isPrimeNumber(sum)) answer++;
            }
        }
    }

    return answer;
}