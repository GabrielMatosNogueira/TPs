#include <stdio.h>
#include <stdbool.h>

int inputLength(const char *input)
{
    int i = 0;

    while (input[i] != '\0')
    {
        i = i + 1;
    }

    return i;
}

bool inputVogal(const char *input)
{
    int i = 0;
    bool verification = true;
    while (i != inputLength(input) && verification)
    {
        if (!(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u' || input[i] == 'A' || input[i] == 'E' || input[i] == 'I' || input[i] == 'O' || input[i] == 'U'))
        {
            verification = false;
        }
        i = i + 1;
    }
    return verification;
}

bool inputConsoante(const char *input)
{
    int i = 0;
    bool verification = true;
    while (i != inputLength(input) && verification)
    {
        if (!((input[i] >= 'a' && input[i] <= 'z') || (input[i] >= 'A' && input[i] <= 'Z')))
        {
            verification = false;
        }
        i = i + 1;
    }
    return verification;
}

bool inputInteiro(const char *input)
{
    int i = 0;
    bool verification = true;
    while (i != inputLength(input) && verification)
    {
        if (!(input[i] >= '0' && input[i] <= '9'))
        {
            verification = false;
        }
        i = i + 1;
    }
    return verification;
}

bool inputReal(const char *input)
{
    int i = 0;
    bool verification = true;
    int commaCount = 0;
    while (i != inputLength(input) && verification)
    {
        if (!((input[i] >= '0' && input[i] <= '9') || input[i] == '.' || input[i] == ','))
        {
            verification = false;
        }
        else
        {
            if (input[i] == '.' || input[i] == ',')
            {
                commaCount = commaCount + 1;
            }
            if (commaCount > 1)
            {
                verification = false;
            }
        }
        i = i + 1;
    }
    return verification;
}

int main(void)
{
    char input[500];

    fgets(input, 500, stdin);
    int len = inputLength(input);
    if (len > 0 && input[len - 1] == '\n')
        input[len - 1] = '\0';

    while (!(input[0] == 'F' && input[1] == 'I' && input[2] == 'M' && input[3] == '\0'))
    {

        if (inputVogal(input))
            printf("SIM ");
        else
            printf("NAO ");

        if (inputConsoante(input))
            printf("SIM ");
        else
            printf("NAO ");

        if (inputInteiro(input))
            printf("SIM ");
        else
            printf("NAO ");

        if (inputReal(input))
            printf("SIM\n");
        else
            printf("NAO\n");

        fgets(input, 500, stdin);
        len = inputLength(input);
        if (len > 0 && input[len - 1] == '\n')
            input[len - 1] = '\0';
    }
    return 0;
}