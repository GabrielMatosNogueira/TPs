#include <stdio.h>
#include <stdbool.h>

int stringLength(const char *phrase)
{
    int length=0;

    while (phrase[length]!='\0')
    {
        length=length+1;
    } 
    return length;
}

int main(void)
{
    char phrase[100]="";
    scanf("%s", phrase);


}

bool palindromeVerify(const char* phrase, int left, int right)
{
    bool verification=false;
    int length=0;
    if(left>right)
    {
        return verification;
    }
    else
    {
        right=right+1;
        if(phrase[left])
    }
}