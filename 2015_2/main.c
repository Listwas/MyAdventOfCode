#include <stdio.h>

int smallest_num(int a, int b, int c) {
    if (a <= b && a <= c) {
        return a;
    } 
    else if (b <= a && b <= c) {
        return b;
    }
    else {
        return c;
    }
}

int main() {    
    FILE *f = fopen("input", "r");

    if (!f) {
        perror("file error: open\n");
        return 1;
    }

    fseek(f, 0, SEEK_END);
    int f_len = ftell(f);
    fseek(f, 0, SEEK_SET);

    char f_con[f_len + 1];
    fread(f_con, 1, f_len, f);
    f_con[f_len] = 0;
    fclose(f);


    int l, w, h;
    char *ptr = f_con;
    int sum = 0;

    while (*ptr) {
        int consumed;
        if (sscanf(ptr, "%dx%dx%d%n", &l, &w, &h, &consumed) == 3){
            // printf("l=%d\nw=%d\nh=%d\n", l, w, h);
            int x = l * h;
            int y = w * h;
            int z = l * w;

            int smallest = smallest_num(x, y, z);
            int bracket = 2 * (x + y + z) + smallest;  

            sum += bracket;
            ptr += consumed;
        } else {
            break;
        }
    }
    printf("%d\n", sum);
}