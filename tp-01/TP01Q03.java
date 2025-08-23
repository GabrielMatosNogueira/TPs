import java.util.Scanner;
class TP01Q01
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String phrase="\0";
        //int length=0;
        int key=3;

        do
        {
            phrase=sc.nextLine();
            //length=phrase.length();
            System.out.println(cifraCesar(phrase, key));
        }while(phrase.charAt(0)!='F' && phrase.charAt(1)!='I' && phrase.charAt(2)!='M');
        
        sc.close();
    }

    public static String cifraCesar(String phrase, int key)
    {
        int i = 0;
        String encrypted = "";
        while (i < phrase.length()) 
        {
            char c = (char) (phrase.charAt(i) + key);
            encrypted += c;
            i = i + 1;
        }
        return encrypted;
    }
}
