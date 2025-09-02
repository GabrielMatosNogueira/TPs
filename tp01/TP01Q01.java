import java.util.Scanner;

class TP01Q01 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        boolean verification = false;
        String phrase = null;
        phrase = sc.nextLine();
        while (!(phrase.length()==3 && phrase.charAt(0)=='F' && phrase.charAt(1)=='I' && phrase.charAt(2)=='M')) 
        {
            verification = palindromeVerification(phrase);
            if (verification) 
            {
                System.out.println("SIM");
            } else 
            {
                System.out.println("NAO");
            }
            phrase = sc.nextLine();
        }

        sc.close();
    }

    public static boolean palindromeVerification(String phrase) 
    {
        boolean verification = true;
        int stringLength = 0;
        int i = 0;
        stringLength = phrase.length();

        do 
        {
            if (phrase.charAt(i) != phrase.charAt(stringLength - i -1)) 
            {
                verification = false;
            }
            i = i + 1;
        } while (i < stringLength / 2 && verification == true);

        return verification;
    }
}