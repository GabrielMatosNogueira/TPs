import java.util.Scanner;
class TP01Q03
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String phrase="";
        phrase = sc.nextLine();

        while(!(phrase.length()==3 && phrase.charAt(0)=='F' && phrase.charAt(1)=='I' && phrase.charAt(2)=='M'))
        {
            System.out.println(cifraCesar(phrase));
            phrase=sc.nextLine();
        }
        
        sc.close();
    }

    public static String cifraCesar(String phrase)
    {
        int i = 0;
        String encrypted = "";
        char c;
        while (i < phrase.length()) 
        {
            if((char)(phrase.charAt(i) + 3) >=32 && (char)(phrase.charAt(i) + 3) <= 126)
            {
                c = (char)(phrase.charAt(i) + 3);
                encrypted += c;
            }
            else
            {
                encrypted+=phrase.charAt(i);
            }

            i = i + 1;
        }
        return encrypted;
    }
}
