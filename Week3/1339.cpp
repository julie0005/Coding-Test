/*
단어수학
-영향력 있는 요소부터 먼저 처리.
*/
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;
vector<string> wordBoard;
int result = 0;
int alpha[26] = {0};

void calculate()
{
    for (int i = 0; i < wordBoard.size(); i++)
    {
        int power = 1;
        for (int j = wordBoard[i].size() - 1; j >= 0; j--)
        {
            //각 단어의 맨 뒤부터 하나씩 처리. 일의자리 수부터.
            int index = wordBoard[i][j] - 'A';
            alpha[index] += power;
            power *= 10;
        }
    }
    //영향력 다 계산했으면 오름차순으로 정렬
    sort(alpha, alpha + 26);
    //우리가 얻어야 하는 것은 결국, 최댓값. 어떤 알파벳이 어떤 숫자로 바뀌었는지는 출력할 필요 없음.
    //따라서 계산해둔 값에 큰 숫자를 순서대로 곱해준 뒤 더하면 됨.
    int value = 9; //알파벳에 부여되는 숫자
    for (int i = 25; i >= 0; i--)
    {
        if (alpha[i] == 0)
            break;
        result += alpha[i] * value;
        value--;
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int num;
    string input;
    cin >> num;
    for (int i = 0; i < num; i++)
    {
        cin >> input;
        wordBoard.push_back(input);
    }
    calculate();
    cout << result << "\n";
    return 0;
}