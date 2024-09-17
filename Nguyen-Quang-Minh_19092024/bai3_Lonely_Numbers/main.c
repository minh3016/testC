#include <stdio.h>
#include <string.h>

// Function to check if a digit appears alone and insert duplicates around it
void numbersNeedFriendsToo(int num) {
    char str[100];
    sprintf(str, "%d", num); // Convert the integer to a string
    
    int len = strlen(str);
    
    for (int i = 0; i < len; i++) {
        // Check if the current digit is a group of one
        if ((i == 0 || str[i] != str[i - 1]) && (i == len - 1 || str[i] != str[i + 1])) {
            // Insert the digit on both sides of itself
            printf("%c%c%c", str[i], str[i], str[i]);
        } else {
            // Otherwise, just print the digit
            printf("%c", str[i]);
        }
    }
    printf("\n"); // New line after the result
}

int main() {
    // Test cases
    numbersNeedFriendsToo(22733);   // Output: 2277733
    numbersNeedFriendsToo(4666);    // Output: 444666
    numbersNeedFriendsToo(123);     // Output: 111222333
    numbersNeedFriendsToo(56657);   // Output: 55566555777
    numbersNeedFriendsToo(33);      // Output: 33
    numbersNeedFriendsToo(456);
    return 0;
}

