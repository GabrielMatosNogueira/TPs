import java.util.Scanner;

public class TP02Q05 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner (System.in);
        String input01 = "";

        input01 = scanner.nextLine();
        

        while(!(input01.length() == 3 && input01.charAt(0) == 'F' && input01.charAt(1) == 'I' && input01.charAt(2) == 'M')) 
        {
            stringTreatment(input01);
            input01 = scanner.nextLine();
        }        
    }

    public static void stringTreatment(String input01)
    {
        String result01="";
        String result02="";
        int i=0;
        int j=0;
        int critPoint=0;
        
        while (input01.charAt(i)!=' ') 
        {
            result01 = result01 + input01.charAt(i);
            i=i+1;
        }

        while(input01.charAt(i)!=' ' && input01.charAt(i+2)!=' ')
        {
            critPoint = i+1;
        }

        critPoint=critPoint+4;

        fe
        {
            result02=result02+input01.charAt(j);
        }

        System.out.println(result01 + "\n");
        System.out.println(result02);
        
    }

    public static boolean verify(String input01, String input02)
    {
        boolean verify=true;

        return verify;
    }
}
