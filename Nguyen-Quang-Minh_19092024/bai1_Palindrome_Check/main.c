#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Function to check if a string is a palindrome
int isPalindrome(char str[]) {
    int len = strlen(str);
    int start = 0, end = len - 1;

    while (start < end) {
        // Convert both characters to lowercase for case-insensitivity
        char leftChar = tolower(str[start]);
        char rightChar = tolower(str[end]);

        // Check if the characters are the same
        if (leftChar != rightChar) {
            return 0; // Not a palindrome
        }
        start++;
        end--;
    }
    return 1; // It's a palindrome
}

int main() {
    char str1[] = "cmc";
    char str2[] = "coding";

    // Test case 1
    if (isPalindrome(str1))
        printf("%s is a palindrome\n", str1);
    else
        printf("%s is not a palindrome\n", str1);

    // Test case 2
    if (isPalindrome(str2))
        printf("%s is a palindrome\n", str2);
    else
        printf("%s is not a palindrome\n", str2);

    return 0;
}

