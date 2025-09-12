import java.util.Scanner;

public class TP03Q03v03 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String input01 = "";
        int stringLength = 0;
        int index = 0;
        int sum = 0;
        int result = 0;

        input01 = sc.nextLine();
        stringLength = input01.length() - 1;

        while(!(input01.charAt(0) == 'F' && input01.charAt(1) == 'I' && input01.charAt(2) == 'M' && input01.length() == 3))
        {
            result = sum(input01, index, stringLength, sum);
            System.out.println(result);

            input01 = sc.nextLine();
            stringLength = input01.length() - 1;
        }

    }

    // 12345    1234    123     12      1       0
    // sum:0    sum:5   sum:9   sum:12  sum:14  sum:15      
    public static int sum(String number01, int index, int length, int sum)
    {
        if(length < index)
        {
            return sum;
        }
        else
        {
            sum = sum + (number01.charAt(length) - '0');
            return sum(number01, index, length-1, sum);
        }
    }
}
