#include <stdio.h>
#include <string.h>

// Function to swap first and last characters of a string
const char* switcharoo(char str[]) {
    int len = strlen(str);

    // Condition 1: If the string length is less than two
    if (len < 2) {
        return "Incompatible.";
    }

    // Condition 2: If the first and last characters are the same
    if (str[0] == str[len - 1]) {
        return "Two's a pair.";
    }

    // Swap the first and last characters
    char temp = str[0];
    str[0] = str[len - 1];
    str[len - 1] = temp;

    // Return the modified string
    return str;
}

int main() {
    // Test cases
    char str1[] = "Cat, dog, and mouse.";
    char str2[] = "ada";
    char str3[] = "Ada";
    char str4[] = "Z";

    printf("%s -> %s\n", str1, switcharoo(str1));  // Output: oellh
    printf("%s -> %s\n", str2, switcharoo(str2));  // Output: ba
    printf("%s -> %s\n", str3, switcharoo(str3));  // Output: Incompatible.
    printf("%s -> %s\n", str4, switcharoo(str4));  // Output: Two's a pair.

    return 0;
}

