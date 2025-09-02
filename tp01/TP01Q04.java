import java.util.Random;
import java.util.Scanner;

public class TP01Q04 
{
    public static void main(String[] args) 
    {
        String phrase = "";
        Scanner sc = new Scanner(System.in);

        Random gerador = new Random();
        gerador.setSeed(4);

        phrase = sc.nextLine();

        while (!(phrase.length()==3 && phrase.charAt(0)=='F' && phrase.charAt(1)=='I' && phrase.charAt(2)=='M')) 
        {
            char char01 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            char char02 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

            String phraseResult = "";

            for (int i = 0; i < phrase.length(); i=i+1) 
            {
                if (phrase.charAt(i) == char01) 
                {
                    phraseResult += char02;
                } 
                else 
                {
                    phraseResult += phrase.charAt(i);
                }
            }

            System.out.println(phraseResult);
            phrase = sc.nextLine();
        }
        sc.close();
    }
}
