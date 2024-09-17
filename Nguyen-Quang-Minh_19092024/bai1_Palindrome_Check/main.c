#include <stdio.h>
#include <string.h>


int checkPalindrome(char* str) {
    int len = strlen(str);
    int start = 0, end = len - 1;

    while (start < end) {
       
        if (str[start] != str[end]) {
            return -1; 
        }
        start++;
        end--;
    }
    return 1; 
}

void isPalindrome(char* str) {
    if (checkPalindrome(str))
        printf("%s is a palindrome\n", str);
    else
        printf("%s is not a palindrome\n", str);
}

int main() {
    
    char str1[] = "cmc";
    char str2[] = "Coding";
    isPalindrome(str1);
    isPalindrome(str2);

    return 0;
}
