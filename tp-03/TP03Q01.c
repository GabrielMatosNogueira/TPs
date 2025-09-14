#include <stdio.h>
#include <stdbool.h>

int stringLength(const char string[])
{
    int i=0;

    while(string[i]!='\n'){i=i+1;}

    return i;
}

bool isWovel(const char string[], int index, bool condition)
{
    bool result;
    if (string[index] == '\0' || string[index] == '\n') 
    {
        result = true;
    }
    else if (!(string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U' ||
               string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u')) 
    {
        condition = false;
        result = condition;
    } 
    else 
    {
        condition = isWovel(string, index+1, condition);
        result = condition;
    }
    return result;
}

bool isConsoant(const char string[], int index, bool condition)
{
    bool result;
    if (string[index] == '\0' || string[index] == '\n') 
    {
        result = true;
    }
    else if ((string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U' ||
               string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u') && !(string[index] >=0 && string[index] <= 9) ) 
    {
        condition = false;
        result = condition;
    } 
    else 
    {
        condition = isConsoant(string, index+1, condition);
        result = condition;
    }
    return result;
}

bool isNumber(const char string[], int index, bool condition)
{
    bool result;
    if (string[index] == '\0' || string[index] == '\n') 
    {
        result = true;
    }
    else
    {
        if(!(string[index]>=0 && string[index]<=9))
        {
            condition = false;
            result = condition;
        }
        else 
        {
            condition = isConsoant(string, index+1, condition);
            result = condition;
        }
    }
    return result;
}

bool isRealNumber()

int main(void)
{
    char string[100]="";
    int index = 0;
    bool condition = false;

    fgets(string, 100, stdin);

    while (!(stringLength(string) == 3 && string[0] == 'F' && string[1] == 'I' && string[2] == 'M'))
    {
        if(isWovel(string, index, condition)){printf("SIM ");} else {printf("NAO ");}
        if(isConsoant(string, index, condition)){printf("SIM ");} else {printf("NAO ");}
        if(isNumber(string, index, condition)){printf("SIM ");} else {printf("NAO ");}

        fgets(string, 100, stdin);
    }

    return 0;
}