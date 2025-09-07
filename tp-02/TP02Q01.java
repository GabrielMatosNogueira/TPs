import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TP02Q01 
{
    private static boolean boolArg(String arg) 
    {
        boolean result = false;
        if (arg.equals("1")) {
            result = true;
        }
        return result;
    }

    private static String boolToString(boolean arg) 
    {
        String result = "0";
        if (arg) {
            result = "1";
        }
        return result;
    }

    private static int charToInt(char c) 
    {
        return c - '0';
    }

    private static boolean or(List<String> args) 
    {
        boolean resp = false;
        int i = 0;
        while (i < args.size()) 
        {
            String arg = args.get(i);
            if(boolArg(arg)) 
            {
                resp = true;
            }
            i++;
        }
        return resp;
    }

    private static boolean and(List<String> args) 
    {
        boolean resp = true;
        int i = 0;
        while (i < args.size()) 
        {
            String arg = args.get(i);
            if(!boolArg(arg)) 
            {
                resp = false;
            }
            i++;
        }
        return resp;
    }

    private static boolean not(boolean arg) 
    {
        boolean result = true;
        if (arg) {
            result = false;
        }
        return result;
    }

    private static boolean valueOfArgument(List<Integer> arguments, char letter) 
    {
        int idx = 0;
        char lower = letter;
        if (letter >= 'A' && letter <= 'Z') {
            lower = (char)(letter + 32);
        }
        idx = lower - 'a';
        boolean result = false;
        if (arguments.get(idx) == 1) {
            result = true;
        }
        return result;
    }

    private static int getClosedIndex(String cmd, int i) 
    {
        int open = 0;
        int result = i;
        while (result < cmd.length()) 
        {
            char c = cmd.charAt(result);
            if(c=='(') 
            {
                open++;
            } 
            else if(c == ')') 
            {
                open--;
            }
            if(open == 0) 
            {
                return result;
            }
            result++;
        }
        return result;
    }

    private static int getVariables(String cmd, List<Integer> arguments) 
    {
        int i = 0;
        int qtd = 0;
        while (cmd.charAt(i) != ' ') 
        {
            qtd = (qtd * 10) + charToInt(cmd.charAt(i));
            i++;
        }
        i++;
        int j = 0;
        while (j < qtd) 
        {
            arguments.add(charToInt(cmd.charAt(i)));
            i += 2;
            j++;
        }
        return i;
    }

    private static void doOperations(Stack<String> p) 
    {
        List<String> listOfArgs = new ArrayList<>();
        while(p.peek().charAt(0) == '0' || p.peek().charAt(0) == '1') 
        {
            listOfArgs.add(p.pop());
        }

        String operation = p.pop();
        boolean res = false;
        if (operation.equals("not")) {
            res = not(boolArg(listOfArgs.get(0)));
        } else if (operation.equals("and")) {
            res = and(listOfArgs);
        } else {
            res = or(listOfArgs);
        }
        p.push(boolToString(res));
    }

    private static String methods(String cmd) 
    {
        String result = "not";
        if(cmd.length() == 2 && cmd.charAt(0) == 'o' && cmd.charAt(1) == 'r') 
        {
            result = "or";
        } 
        else if(cmd.length() == 2 && cmd.charAt(0) == 'n' && cmd.charAt(1) == 'd') 
        {
            result = "and";
        }
        return result;
    }

    private static void parse(String cmd, List<Integer> arguments, Stack<String> p, int i) 
    {
        if(i >= cmd.length()) 
        {
            return;
        }

        char c = cmd.charAt(i);
        int icpy = i+1;
        if(c == '(') 
        {
            int j = getClosedIndex(cmd, i);
            String op = "";
            int k = i-2;
            while (k < i) {
                op = op + cmd.charAt(k);
                k++;
            }
            p.push(methods(op));
            String sub = "";
            int m = i+1;
            while (m < j) {
                sub = sub + cmd.charAt(m);
                m++;
            }
            parse(sub, arguments, p, 0);
            doOperations(p);
            icpy = j;
        } 
        else if(c >= 'A' && c <= 'Z') 
        {
            p.push(boolToString(valueOfArgument(arguments, c)));
        }

        parse(cmd, arguments, p, icpy);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        while(!text.equals("0")) 
        {
            Stack<String> p = new Stack<>();
            List<Integer> arguments = new ArrayList<>();
            int i = getVariables(text, arguments);
            parse(text, arguments, p, i);
            System.out.println(p.pop());
            text=sc.nextLine();
        }
        sc.close();
    }
}
