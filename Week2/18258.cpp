#include <iostream>
#include <queue>
#include <string>
using namespace std;


int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	queue<int> queue;
	int n;
	string order;
	int num;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> order;
		if (order.find("push") == 0) {
			cin >> num;
			queue.push(num);
		}
		else if (order.find("pop") == 0) {
			if (!queue.empty()) {
				cout << queue.front() << '\n';
				queue.pop();
			}
			else {
				cout << -1 << '\n';
			}
		}
		else if (order.find("size") == 0) {
			cout << queue.size() << '\n';
		}
		else if (order.find("empty") == 0) {
			if (queue.empty()) {
				cout << 1 << '\n';
			}
			else {
				cout << 0 << '\n';
			}
		}
		else if (order.find("front") == 0) {
			if (queue.empty()) {
				cout << -1 << '\n';
			}
			else {
				cout << queue.front() << '\n';
			}
		}
		else if (order.find("back") == 0) {
			if (queue.empty()) {
				cout << -1 << '\n';
			}
			else {
				cout << queue.back() << '\n';
			}
		}


	}




	return 0;
}
