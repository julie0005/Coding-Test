#include <stdio.h>
int mergedsort[1000001];
int initlist[1000001];

void merge(int list[], int tmp[], int start, int mid, int end) {
	for (int i = start; i <= end; i++) {
		tmp[i] = list[i]; 
	}
	int part1 = start;
	int part2 = mid + 1;
	int index = start;
	while (part1 <= mid && part2 <= end) {
		if (tmp[part1] <= tmp[part2]) {
			list[index++] = tmp[part1++];
		}
		else {
			list[index++] = tmp[part2++];
		}
	}
	for (int i = 0; i <= mid - part1; i++) {
		list[index + i] = tmp[part1 + i];
	}
}


void mergeSort(int list[], int tmp[], int start, int end) {
	if (start < end) {
		int mid = (start + end) / 2;
		mergeSort(list, tmp, start, mid);
		mergeSort(list, tmp, mid + 1, end);
		merge(list, tmp, start, mid, end);
	}

}


int main() {
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &initlist[i]);
	}
	mergeSort(initlist, mergedsort, 0, n-1);
	for (int i = 0; i < n; i++) {
		printf("%d\n", initlist[i]);
	}


}