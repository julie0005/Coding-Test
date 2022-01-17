#include <stdio.h>
#include <stdlib.h>


//Counting Sort
int main(){

    int n;
    int index;
    int max=0;
    scanf("%d",&n);
    int list[10002]={0};
    for(int i=1; i<=n; i++){
        scanf("%d",&index);
        list[index]++;
        if(index>max){
            max=index;
        }
    }
    for(int i=1; i<=max; i++){
        for(int j=0; j<list[i];j++){
            printf("%d\n",i);

        }
    }

    return 0;
}