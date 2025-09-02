import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TP01Q04a {
    public static String substituirLetra(String s, char a, char b) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                arr[i] = b;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Random gerador = new Random();
        gerador.setSeed(4);

        while (true) {
            String linha = br.readLine();
            if (linha == null || linha.equals("FIM")) break;
            char a = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            char b = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            System.out.println(substituirLetra(linha, a, b));
        }
    }
}