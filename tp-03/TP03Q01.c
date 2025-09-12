#include <stdio.h>
#include <stdbool.h>

int stringLength(char * string, int index)
{
    int length=0;
    if(string[index] == '\0')
    {
        return index;
    }
    else
    {
        length++;
        stringLength(string, index+1);

        return length;
    }
}

bool isVowel(char *string, int index)
{
    if(string[index] == '\0')
    {
        
    }
}

bool validateVowelComposition(char * string, int index, bool validation)
{
    if((string[index] == '\0'))
    {
        return validation;
    }
    else
    {
        if((string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U') ||
           (string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u'))
        {
            validateVowelComposition(string, index+1, validation);
        }
        else
        {
            validateVowelComposition(string, stringLength(string, 0), !validation);
        }
    }
}



int main(void)
{
    char string[100] = "";
    int strLength = 0;
    int index = 0;
    bool vaderValidator = true;

    fgets(string, 100, stdin);

    while(string[0] != 'F' && string[1] != 'I' && string[2] != 'M' && stringLength(string, index) != 3)
    {
        if(validateVowelComposition(string, index, vaderValidator)){printf("SIM ");}else{printf("NAO ");}
        //if(validateConsoantComposition(string, index, vaderValidator)){printf("SIM ");}else{printf("NAO ");}
        //if(validateNumberComposition(string, index, vaderValidator)){printf("SIM ");}else{printf("NAO ");}
        //if(validateRealNumberComposition(string, index, vaderValidator)){printf("SIM ");}else{printf("NAO ");}

        scanf(" %s", string);
        getchar( );
    }

    return 0;
}