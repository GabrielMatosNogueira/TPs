#include <stdio.h>
#include <string.h>

/**
 * @brief Calcula a soma dos digitos de um número inteiro de forma recursiva.
 *
 * @param n O número inteiro cujos dígitos serão somados.
 * @return A soma dos dígitos de n.
 *
 * Se n for menor que 10, retorna o próprio n (caso base).
 * Caso contrário, retorna o último dígito de n (n % 10) somado à soma dos dígitos do número sem o último dígito (n / 10).
 */
int somaDigitos(int n)
{
    if (n < 10)
        return n;
    else
        return (n % 10) + somaDigitos(n / 10);
}

int main(void)
{
    char entrada[4]="";
    int numero = 0;
    int resultado = 0;

    scanf("%s", entrada);
    while (!(entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M' && entrada[3] == '\0'))
    {
        sscanf(entrada, "%d", &numero);
        resultado = somaDigitos(numero);
        printf("%d\n", resultado);
        scanf("%s", entrada);
    }

    return 0;
}
