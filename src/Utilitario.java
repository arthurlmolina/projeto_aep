import java.util.Random;
import java.util.Scanner;

public class Utilitario {
    private Utilitario() {}

    public static void login(){
        Scanner scanner = new Scanner(System.in);
        int optionMenuInicial;
        System.out.println("1 - Cidadão");
        System.out.println("2 - Funcionario");
        System.out.print("Escolha uma opção: ");
        optionMenuInicial = scanner.nextInt();
        pularLinhas();
        switch (optionMenuInicial){
            case 1:
                Cidadao.loginCidadao();
                break;
            case 2:

                break;
            default:
                System.out.println("Opção inválida, tente novamente");
                login();
                break;
        }
    }

    public static void pularLinhas(){
        System.out.println("\n\n\n");
    }
}
