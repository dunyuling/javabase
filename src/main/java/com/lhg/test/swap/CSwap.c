#include <stdio.h>

void swap(int x,int y);
void swapR(int &x,int &y);
int main() {
    int x = 10,y = 20;
    printf("%s%d\t%s%d\n","being:  x=",x ,"y=",y);
    swap(x,y);
    printf("%s%d\t%s%d\n","swap:  x=",x ,"y=",y);
    swapR(x,y);
    printf("%s%d\t%s%d\n","swapR:  x=",x ,"y=",y);
    return 0;
}


void swap(int x , int y) {
    int temp=0;
    temp = x;
    x = y;
    y = temp;
}

void swapR(int &x , int &y) {
    int temp=0;
    temp = x;
    x = y;
    y = temp;
}

