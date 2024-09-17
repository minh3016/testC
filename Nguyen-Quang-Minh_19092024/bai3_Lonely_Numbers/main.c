#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void numbersNeedFriendsToo(int num) {
    char *str = (char *)malloc(100 * sizeof(char)); 
    if (str == NULL) {
        printf("Memory allocation failed\n");
        return;
    }

    sprintf(str, "%d", num); 
    
    char *ptr = str;
    char *end = str + strlen(str); 
    
    while (ptr < end) {
        
        if ((ptr == str || *ptr != *(ptr - 1)) && (ptr == end - 1 || *ptr != *(ptr + 1))) {
            
            printf("%c%c%c", *ptr, *ptr, *ptr);
        } else {
            
            printf("%c", *ptr);
        }
        ptr++; 
    }

    free(str); 
    printf("\n"); 
}

int main() {
    
    numbersNeedFriendsToo(22733);   
    numbersNeedFriendsToo(4666);    
    numbersNeedFriendsToo(123);     
    numbersNeedFriendsToo(56657);   
    numbersNeedFriendsToo(33);      
    numbersNeedFriendsToo(456);
    return 0;
}
