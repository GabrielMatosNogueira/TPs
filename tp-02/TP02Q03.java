import java.util.Scanner;
public class TP02Q03 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String input="";
        
        input=scanner.nextLine();

        while(!(input.length()==3 && input.charAt(0)=='F' && input.charAt(1)=='I' && input.charAt(2)=='M')) 
        {
            invertString(input);
            input = scanner.nextLine();
        }
        
        scanner.close();
    }
    
    /**
     * Function to return inverted string
     * @param input
     * @return invertedString
     */
    public static String invertString(String input)
    {
        int i=0;
        int n=input.length()-1;
        String invertedString="";

        for(i = n; i >= 0; i--)
        {
            invertedString += input.charAt(i);
        }

        System.out.println(invertedString);

        return invertedString;
    }
}
