/* 1546 평균 */

#include <iostream>
#include <vector>
using namespace std;

int main(){
    int subject_num;
    int max_score=0;
    vector<int> scores;

    cin>>subject_num;

    double new_average;
    double new_score_sum=0;

    for(int i=0; i<subject_num; i++){
        int score;
        cin>>score;
        scores.push_back(score);
        if(max_score<score) max_score=score;
    }

    for(int i=0; i<subject_num; i++){
        double new_score=scores[i]/(double)max_score*100.0;
        new_score_sum+=new_score;
    }
    cout<<new_score_sum/(double)subject_num;
    return 0;
}