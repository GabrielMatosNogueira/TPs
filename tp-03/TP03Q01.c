#include <stdio.h>
#include <stdbool.h>

int stringLength(const char string[])
{
    int i = 0;
    while (string[i] != '\0' && string[i] != '\n')
    {
        i = i + 1;
    }
    return i;
}

bool isWovel(const char string[], int index, bool condition)
{
    bool result = true;
    if (string[index] == '\0' || string[index] == '\n')
    {
        result = true;
    }
    else
    {
        if (!(string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U' ||
              string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u'))
        {
            result = false;
        }
        else
        {
            result = isWovel(string, index + 1, condition);
        }
    }
    return result;
}

bool isConsoant(const char string[], int index, bool condition)
{
    bool result = true;
    if (string[index] == '\0' || string[index] == '\n')
    {
        result = true;
    }
    else
    {
        if (string[index] >= '0' && string[index] <= '9')
        {
            result = false;
        }
        else
        {
            if (string[index] == 'A' || string[index] == 'E' || string[index] == 'I' || string[index] == 'O' || string[index] == 'U' ||
                string[index] == 'a' || string[index] == 'e' || string[index] == 'i' || string[index] == 'o' || string[index] == 'u')
            {
                result = false;
            }
            else
            {
                if ((string[index] >= 'A' && string[index] <= 'Z') || (string[index] >= 'a' && string[index] <= 'z'))
                {
                    result = isConsoant(string, index + 1, condition);
                }
                else
                {
                    result = false;
                }
            }
        }
    }
    return result;
}

bool isNumber(const char string[], int index, bool condition)
{
    bool result = true;
    if (string[index] == '\0' || string[index] == '\n')
    {
        result = true;
    }
    else
    {
        if ((string[index] >= '0' && string[index] <= '9'))
        {
            result = isNumber(string, index + 1, condition);
        }
        else
        {
            result = false;
        }
    }
    return result;
}

bool isRealNumber(const char string[], int index, bool condition, int commaAndDot)
{
    bool result = false;
    if (string[index] == '\0' || string[index] == '\n')
    {
        result = (commaAndDot == 1 && index > 1);
    }
    else
    {
        if (string[index] >= '0' && string[index] <= '9')
        {
            result = isRealNumber(string, index + 1, condition, commaAndDot);
        }
        else if ((string[index] == '.' || string[index] == ',') && commaAndDot == 0)
        {
            result = isRealNumber(string, index + 1, condition, commaAndDot + 1);
        }
        else
        {
            result = false;
        }
    }
    return result;
}

int main(void)
{
    char string[200] = "";
    int index = 0;
    bool condition = false;

    fgets(string, 200, stdin);

    while (!(stringLength(string) == 3 && string[0] == 'F' && string[1] == 'I' && string[2] == 'M'))
    {
        if(isWovel(string, index, condition)){printf("SIM ");} else {printf("NAO ");}
        if(isConsoant(string, index, condition)){printf("SIM ");} else {printf("NAO ");}
        if(isNumber(string, index, condition)){printf("SIM ");} else {printf("NAO ");}
        if(isRealNumber(string, index, condition, 0)){printf("SIM\n");} else {printf("NAO\n");}

        fgets(string, 200, stdin);
    }

    return 0;
}
