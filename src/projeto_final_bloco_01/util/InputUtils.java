package projeto_final_bloco_01.util;

import java.util.Scanner;

public class InputUtils {
	
	private static final Scanner leia = new Scanner(System.in);

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(leia.nextLine());
                
            } catch (NumberFormatException e) {
                System.err.println("❌ Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static float lerFloat(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = leia.nextLine();
                return Float.parseFloat(entrada);
            } catch (NumberFormatException e) {
                System.err.println("❌ Entrada inválida. Digite um número decimal (ex: 10,5).");
            }
        }
    }

}
