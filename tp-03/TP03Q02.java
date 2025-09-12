import java.util.Scanner;

public class TP03Q02 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        String input01 = "";
        String input02 = "";
        int n = 0;

        input01 = sc.nextLine();
        n = input01.length();

        while( ! (input01.charAt(0) == 'F' && input01.charAt(1) == 'I' && input01.charAt(2) == 'M' && input01.length() == 3))
        {
            input02 = invertedString(input01, n-1);
            System.out.println(input02);

            input01 = sc.nextLine();
            n = input01.length();
        }

        sc.close();
    }

    public static String invertedString(String input01, int index)
    {
        String invertedString01 = "";

        if(index < 0)
        {
            return invertedString01;
        }
        else
        {
            invertedString01 = invertedString01 + input01.charAt(index);
            return invertedString01 + invertedString(input01, index-1);
        }
    }
}
