#include <stdio.h>

int main()
{
    int arr[6] = {10, 20, 30, 40, 50};
    int size = 5;
    int pos = 2, num = 25;

    for (int i = size; i > pos; i--) {
        arr[i] = arr[i-1];
    }

    arr[pos] = num;
    size++;

    for (int i = 0; i <size; i++) {
        printf("%d ", arr[i]);
    }
}








