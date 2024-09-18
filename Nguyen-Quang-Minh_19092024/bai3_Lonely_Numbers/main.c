#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <limits.h>


char* longToString(long num) {
    
    char *str = (char *)malloc(21 * sizeof(char)); 
    if (str == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    sprintf(str, "%ld", num); 
    return str;
}


int isUnique(char *str, char *ptr, char *end) {
    return (ptr == str || *ptr != *(ptr - 1)) && (ptr == end - 1 || *ptr != *(ptr + 1));
}


void printResult(char *str) {
    char *ptr = str;
    char *end = str + strlen(str);

    while (ptr < end) {
        if (isUnique(str, ptr, end)) {
            for (int i = 0; i < 3; i++) { 
                printf("%c", *ptr);
            }
        } else {
            printf("%c", *ptr);
        }
        ptr++;
    }
    printf("\n");
}


void numbersNeedFriendsToo(long num) {
    
    if (num > LONG_MAX || num < LONG_MIN) {
        printf("Error: Number out of range for type long.\n");
        return;
    }

    char *str = longToString(num);
    if (str != NULL) {
        printResult(str); 
        free(str);         
    }
}

int main() {
   
    numbersNeedFriendsToo(22733);   
    numbersNeedFriendsToo(4666);    
    numbersNeedFriendsToo(123);     
    numbersNeedFriendsToo(56657);   
    numbersNeedFriendsToo(33);      
    numbersNeedFriendsToo(456);
    
    
    numbersNeedFriendsToo(LONG_MAX + 1L);  
    numbersNeedFriendsToo(LONG_MIN - 1L);  

    return 0;
}
