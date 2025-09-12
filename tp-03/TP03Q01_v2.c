#include <stdio.h>
#include <stdbool.h>

int stringLength(char* string, int index)
{
    if(string[index]=='\0')
    {
        return index;
    }
    else
    {
        stringLength(string, index+1);
    }
}

bool vogalsOnly(char* string, int index, bool crownCondition)
{
    if(string[index] == '\0')
    {
        return crownCondition;
    }
    else
    {
        if((string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U') ||
           (string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u'))
        {
            vogalsOnly(string, index+1, crownCondition);
        }
        else
        {
            crownCondition = false;
            vogalsOnly(string, index+1, crownCondition);
        }
    }
}

bool consonantOnly(char* string, int index, bool crownCondition)
{
    if(string[index] == '\0')
    {
        return crownCondition;
    }
    else
    {
        if(!((string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U') ||
             (string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u')) &&
             (string[index] >= '0' && string[index] <= '9') || (string[index] == ',' || string[index] == '.'))
        {
            consonantOnly(string, index+1, crownCondition);
        }
        else
        {
            crownCondition = false;
            consonantOnly(string, index+1, crownCondition);
        }
    }
}

bool numberOnly(char* string, int index, bool crownCondition)
{
    if(string[index] == '\0')
    {
        return crownCondition;
    }
    else
    {
        if( (string[index] >= '0' && string[index] <= '9') || (string[index] == ',' || string[index] == '.'))
        {
            return numberOnly(string, index+1, crownCondition);
        }
        else
        {
            crownCondition = false;
            return numberOnly(string, index+1, crownCondition);
        }
    }
}

int main(void)
{
    bool crownCondition = true; // Universal condition for each recursive method
    bool crownValidation = false;
    char string[100]="";
    int n=0;
    int index=0;

    scanf(" %s", string);
    n=stringLength(string,index);

    while(string[0]!='F' && string[1]!='I' && string[2]!='M' && string[3]!='\n' && n!=3)
    {
        if(crownValidation = vogalsOnly(string, index, crownCondition)){printf("SIM ");} else {printf("NAO ");};
        if(crownValidation = consonantOnly(string, index, crownCondition)){printf("SIM ");} else {printf("NAO ");};
        if(crownValidation = numberOnly(string, index, crownCondition)){printf("SIM ");} else {printf("NAO ");};
        //if(crownValidation = vogalsOnly(string, index, crownCondition)){printf("SIM\n");} else {printf("NAO\n");};

        scanf(" %s", string);

        n=stringLength(string,index);
    }

    return 0;
}