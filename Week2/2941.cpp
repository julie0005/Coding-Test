#include <iostream>
#include <string>
using namespace std;

bool isNone(int list[], int n) {
	for (int i = 0; i < n; i++) {
		if (list[i] != string::npos) {
			return false;
		}
	}
	return true;
}

int main() {
	string word;
	int index[8] = { 0 };
	cin >> word;

	int cnt = 0;
	int min = 100;
	int mini = 0;
	int i = 0;

	while (i < word.size()) {
		index[0] = word.find("c=", i);
		index[1] = word.find("c-", i);
		index[2] = word.find("dz=", i);
		index[3] = word.find("d-", i);
		index[4] = word.find("lj", i);
		index[5] = word.find("nj", i);
		index[6] = word.find("s=", i);
		index[7] = word.find("z=", i);
		
		if (isNone(index, 8)) {
			//i 이후로 해당 문자열 겹치는거 없음.
			cnt += word.size() - i;
			break;
		}
		else {
			min = 100;
			for (int j = 0; j < 8; j++) {
				if (index[j]!=string::npos &&  min > index[j]) {
					mini = j;
					min = index[j];
				}
			}
			
			cnt += min - i; //전까지 세고
			i += min - i;
			if (mini == 2) {
				//dz=
				i += 3;
			}
			else {
				i += 2;
			}
			cnt += 1;
		}
		
	}
	cout << cnt << '\n';

	return 0;
}