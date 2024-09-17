#include <stdio.h>
#include <string.h>

char* switcharoo(char *str) {
    int len = strlen(str);

    // If the string length is less than two
    if (len < 2) {
        return "Incompatible.";
    }

    //  If the first and last characters are the same
    if (*str == *(str + len - 1)) {
        return "Two's a pair.";
    }

    // Swap the first and last characters 
    char temp = *str;
    *str = *(str + len - 1);
    *(str + len - 1) = temp;

   
    return str;
}
void toString(char *str)
{
    printf("%s -> %s \n", str, switcharoo(str));
}

int main() {
    // Test cases
    char str1[] = "Cat, dog, and mouse.";
    char str2[] = "ada";
    char str3[] = "Ada";
    char str4[] = "Z";

    toString(str1);
    toString(str2);
    toString(str3);
    toString(str4);

    return 0;
}
