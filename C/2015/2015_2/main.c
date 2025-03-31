#include <stdio.h>

void find_two_smallest(int a, int b, int c, int *smallest, int *second_smallest) {
    if (a <= b && a <= c) {
        *smallest = a;
        *second_smallest = (b <= c) ? b : c;
    } 
    else if (b <= a && b <= c) {
        *smallest = b;
        *second_smallest = (a <= c) ? a : c;
    }
    else {
        *smallest = c;
        *second_smallest = (a <= b) ? a : b;
    }
}

int main() {
    FILE *f = fopen("input.txt", "r");
    if (!f) {
        perror("file error: open\n");
        return 1;
    }

    int l, w, h;
    int total_paper = 0;
    int total_ribbon = 0;

    while (fscanf(f, "%dx%dx%d", &l, &w, &h) == 3) {
        // wrapping paper 
        int area1 = l * w;
        int area2 = w * h;
        int area3 = h * l;
        
        int smallest_area, trash;
        find_two_smallest(area1, area2, area3, &smallest_area, &trash);

        int surface_area = 2 * (area1 + area2 + area3);
        total_paper += surface_area + smallest_area;

        // ribbon calculations
        int smallest, second_smallest;
        find_two_smallest(l, w, h, &smallest, &second_smallest);

        int perimeter = 2 * (smallest + second_smallest);
        int volume = l * h * w;
        total_ribbon += perimeter + volume;
    }
    fclose(f);
    
    printf("total square feet of wrapping paper: %d\n", total_paper);
    printf("total feet of ribbon to order: %d\n", total_ribbon);
}