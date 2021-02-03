#include <stdio.h>
#include <string.h>


int main(){
    char sentence[1000005]={0};
    int cnt=0;
    scanf("%[^\n]s",sentence);
    char *ptr=strtok(sentence," ");
    while(ptr!=NULL){
        cnt++; 
        ptr=strtok(NULL, " ");
    }
    printf("%d\n",cnt);
    return 0;
}