import java.util.Scanner;

public class TP02Q01 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        while(!(input.length() == 3 && input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M'))
        {
            inputVogais(input);
            System.out.print(" ");
            inputConsoantes(input);
            System.out.print(" ");
            inputInt(input);
            System.out.print(" ");
            inputReal(input);
            System.out.print(" ");
            System.out.println();
            input = scanner.nextLine();
        }

        scanner.close();
    }

    public static void inputVogais(String str) 
    {
        int i=0;
        boolean verify = true;
        while(i!=str.length() && verify)
        {
            // Negacao da expressao, vogal negada é consoante
            if(!(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U'))
            {
                verify = false;
            }
            i=i+1;
        }

        if(verify)
        {
            System.out.print("SIM");
        }
        else
        {
            System.out.print("NAO");
        }
    }

    public static void inputConsoantes(String str) 
    {
        int i=0;
        boolean verify = true;
        while(i!=str.length() && verify)
        {
            if((str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u' || str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O' || str.charAt(i)=='U') || !(str.charAt(i)>='A' && str.charAt(i)<='Z' || str.charAt(i)>='a' && str.charAt(i)<='z'))
            {
                verify = false;
            }
            i=i+1;
        }

        if(verify)
        {
            System.out.print("SIM");
        }
        else
        {
            System.out.print("NAO");
        }
    }

    public static void inputInt(String str) 
    {
        int i=0;
        boolean verify = true;
        while(i!=str.length() && verify)
        {
            if(!(str.charAt(i)>='0' && str.charAt(i)<='9'))
            {
                verify = false;
            }
            i=i+1;
        }

        if(verify)
        {
            System.out.print("SIM");
        }
        else
        {
            System.out.print("NAO");
        }
    }

    public static void inputReal(String str)
    {
        int i=0;
        int countPontoVirgula = 0;
        boolean verify = true;
        while(i!=str.length() && verify)
        {
            if(!(str.charAt(i)>='0' && str.charAt(i)<='9' || str.charAt(i)=='.' || str.charAt(i)==','))
            {
                verify = false;
            }
            if(str.charAt(i)=='.' || str.charAt(i)==',')
            {
                countPontoVirgula = countPontoVirgula + 1;
            }
            i=i+1;
        }

        if(countPontoVirgula>1)
        {
            verify = false;
        }

        if(verify)
        {
            System.out.print("SIM");
        }
        else
        {
            System.out.print("NAO");
        }
    }
}
