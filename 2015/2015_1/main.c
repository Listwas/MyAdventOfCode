#include <stdio.h>

int main() {
    FILE *f;

    f = fopen("floors.txt", "rb");

    fseek(f, 0L, SEEK_END);
    int f_len = ftell(f);
    fseek(f, 0, SEEK_SET);

    char f_con[f_len+1];
    fread(f_con, 1, f_len, f); 
    f_con[f_len] = 0; // add 0 to the end of file so printf wont crash
    // printf("%s", f_con);
    
    int floor = 1;
    int check = 0;
    for (int i = 0; i < f_len; i++) { // go through each char and update counter    
        if (f_con[i] == '(') {
            floor++;
        } else if (f_con[i] == ')') {
            floor--;
        }

        if (floor == -1 && check == 0) {
            check = i + 1;
        } 
    }


    printf("ending floor: %d\n", floor - 1);
    printf("position: %d\n", check - 1);
    fclose(f);
}