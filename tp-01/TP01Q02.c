/**
 * @brief Palindromo
 *
 * @details Criar um metodo RECURSIVO que recebe uma string como parâmetro e retorna
 *          "true" se for um palindromo. Na saida, para cada linha de entrada, imprima
 *          uma saida com SIM/NAO indicando se a LINHA é um palindromo.
 *          OBS: é possível que uma das linhas de entrada PODE não ser CARACTERES
 *
 * @author @GabrielMatosNogueira
 * @version 0.0.1v
 */
#include <stdio.h>
#include <string.h>
#include <stdbool.h>


/**
 * @brief   Verificacão de existencia de palindromo
 *
 * @details OBS:    Ademais da entrada permitir instâncias não alfabéticas,
 *                  números também podem formar estruturas palíndromicas,
 *                  exemplo como: 2112, 394493, #@@#, 'aa', etc...
 *
 * @param phrase A string a ser analisada.
 * @param left   O índice inicial (esquerda) da substring atual.
 * @param right  O índice final (direita) da substring atual.
 * @return       "true"` se for um palíndromo, "false" caso contrário.
 */
bool verification(const char phrase[], int left, int right)
{
    /**
     * Declaração de variaveis
     */
    bool result = true;

    /**
     * A recursão continua enquanto o índice da esquerda for menor que o da direita.
     * Esta é a condição de parada que garante que a função pare de chamar a si mesma
     * quando o meio da string for alcançado.
     */
    if (left < right)
    {
        /**
         * Verificação dos caracteres nas extremidades da substring
         * caso forem diferentes, a string não é um palíndromo
         */
        if (phrase[left] != phrase[right])
        {
            result = false;
        }
        else
        {
            /**
             * Se os caracteres forem iguais, a função se chama recursivamente para a
             * próxima parte da string, movendo os índices para o centro.
             */
            result = verification(phrase, left + 1, right - 1);
        }
    }

    /**
     * Retorna o resultado da verificação depois da execução
     * da estrutura condicional
     */
    return result;
}

int main(void)
{
    /**
     * Declaração de variáveis
     */
    char phrase[200] = "\0";
    int length = 0;
    int i=0;

    do
    {
        /**
         * Leitura da frase
         */
        fgets(phrase, 200, stdin);

        i = 0;
        length = 0;

        while (phrase[i] != '\0' && phrase[i] != '\n' && i < 201)
        {
            length = length + 1;
            i = i + 1;
        }
        if (phrase[i] == '\n')
        {
            phrase[i] = '\0';
        }

        /**
         * Estrutura condicional IF para exibir o resultado da verificação
         * utilizando a função recursiva 'verification'
         */
        if (verification(phrase, 0, length-1))
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
    } while (!(length == 3 && phrase[0] == 'F' && phrase[1] == 'I' && phrase[2] == 'M'));

    return 0;
}