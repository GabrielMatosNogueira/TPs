import java.util.Scanner;

public class TP03Q03v01 
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String input01 = "";
        int[] array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int length = 0;
        int index = 0;

        input01 = sc.nextLine();
        length = input01.length() - 1;
        index = length;

        while(input01.charAt(0)!= 'F' && input01.charAt(1) != 'I' && input01.charAt(2) != 'M' && input01.length() != 3)
        {

            stringToInt(input01, array, index, length);
            input01 = sc.nextLine();
            length = input01.length() - 1;
            index = length;
        }

        sc.close();
    }

    public static int[] stringToInt(String input01, int[] array, int index, int length)
    {
        if(index <= length)
        {
            return array;
        }
        else
        {
            array[index] = input01.charAt(index);
            return stringToInt(input01, array, index+1, length);
        }
    }

    public static void showSum(int []array, int sum, int index, int length)
    {
        if(index <= length)
        {
            sum = sum + array[index];
            showSum(array, sum, index+1, length);
        }
        else
        {
            System.out.println(sum);
        }
    }
}
