
/**
 * @brief Palindromo
 * 
 * @details Criar um metodo interativo que recebe uma string como parâmetro e retorna
 *          "true" se for um palindromo. Na saida, para cada linha de entrada, imprima
 *          uma saida com SIM/NAO indicando se a LINHA é um palindromo.
 *          OBS: é possível que uma das linhas de entrada PODE não ser CARACTERES 
 * @version 0.0.1
 * @author @GabrielMatosNogueira
 */
import java.util.Scanner;

public class TP01Q01 {
    public static void main(String args[]) 
    {
        /**
         * Declaração de variáveis
         */
        Scanner scanner = new Scanner(System.in);
        String phrase = "";
        int length=0;

        do
        {
            /**
            * Leitura da frase
             */
            phrase = scanner.nextLine();
            //System.out.println(""+phrase);
            length=phrase.length();

            /**
             * Estrutura condicional IF para exibição na tela do resultado obtido pelo
             * retorno da função verification DENTRO da estrutura "IF"
             */

            if(verification(phrase))
            {
                System.out.println("SIM");
            }
            else
            {
                System.out.println("NAO");
            };
        }while(!(length == 3 && phrase.charAt(0)=='F' && phrase.charAt(1)=='I' && phrase.charAt(2)=='M'));

        /**
         * Dispensa do objeto
         */
        scanner.close();
    }

    /**
     * @brief Verifacacao de existencia de palindromo
     * 
     * @details OBS: Ademais da entrada permitir instâncias não alfabéticas,
     *          números também podem formar estruturas palíndromicas,
     *          exemplo como: 2112, 394493, #@@#, 'aa', etc...
     * @param phrase
     * @return verification
     */
    public static boolean verification(String phrase) {
        /**
         * Declaracao de variaveis
         */
        int i = 0;
        boolean verification = true;

        /**
         * Atribuição do tamanho da frase recebido como parâmetro
         * utilizando a função .length da classe "String"
         */
        int length = phrase.length();

        /**
         * Estrutura de repetição utilizando a funcao .chatAt da classe String
         * para comparação entre caracteres
         * 
         */
        do {
            /**
             * Estrutura de verificação onde ocorre a comparação de elementos simétricos,
             * como
             * o primeiro e o último, segundo e penúltimo, etc...
             * A lógica ocorre quando a subtração de "-1" é efetuado no valor do "tamanho"
             * da
             * string pela função .length, uma vez que o índice de strings em Java começa em
             * 0. Ademais, a subtração pelo valor de 'i' garante a simetria da comparação
             * dos
             * elementos, uma vez que será subtraído valores cada vez maiores para cada ite-
             * ração à medida que i tem ser valor atualizado em +1
             */
            if (phrase.charAt(i) != phrase.charAt(length - 1 - i)) 
            {
                verification = false;
            }
            i = i + 1;
        } while (length == 0 && verification == true);

        return verification;
    }
}
/**
 * Prezado corretor, peço desculpas pela "poluição" do código com comentários,
 * caso seja de maior legibilidade e de seu interesse, posso criar um arquivo
 * separado em markDown ou .txt com explicações da lógica-sequência utilizada
 * nos próximos programas.
 * 
 * E-mail: gabriel.nogueira.1563147@sga.pucminas.br
 * Teams: Gabriel Matos Nogueira (1563147@sga.pucminas.br)
 * Whatsapp: (31) 97158-5300
 * Discord: gabrielmnogueira
 */