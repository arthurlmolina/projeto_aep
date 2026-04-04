import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilitario {
    private Utilitario() {};

    public static void login(){
        Scanner scanner = new Scanner(System.in);
        int optionMenuInicial;
        System.out.println("Menu");
        System.out.println("1 - Cidadão");
        System.out.println("2 - Funcionario");
        System.out.print("Escolha uma opção: ");
        optionMenuInicial = scanner.nextInt();
        pularLinhas();
        if (optionMenuInicial == 1){
            Cidadao.loginCidadao();
        }
    }

    public static void pularLinhas(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
