#include <stdio.h>

int main() {
    FILE *f = fopen("input.txt", "r");

    if (!f) {
        perror("file error: open\n");
        return 1;
    }
    
    fseek(f, 0L, SEEK_END);
    int f_length = ftell(f);
    fseek(f, 0L, SEEK_SET);

    char f_content[f_length + 1];
    f_content[f_length] = 0;
    fread(f_content, 1, f_length, f);



    int x[] = {};
    int up = 0;
    for (int i = 0; i < f_length; i++) {
        if (f_content[i] == '^') {
            up++;
        }
        x[i] = up;

        printf("%d\n", x[i]);

    }
    fclose(f);
    // printf("x:%d y:%d\n", x[12]);
}

// TODO
// Make a list and compare entries to detertminate which was visted at least once