import java.util.Scanner;

public class MenuService {

    Scanner scanner = new Scanner(System.in);

    public int escolherTipoUsuario() {
        int opcao = 0;

        while(opcao < 1 || opcao > 2){

            System.out.println("Escolha seu tipo de login:");
            System.out.println("1 - Cidadão");
            System.out.println("2 - Funcionário");
            System.out.println("Digite a opção desejada: ");

            opcao = scanner.nextInt();

        }
        return opcao;
    }

    public int escolherAcao(){

        int opcao = 0;

        while(opcao < 1 || opcao > 2){

            System.out.println("1 - Registrar");
            System.out.println("2 - Login");
            System.out.println("Digite a opção desejada: ");

            opcao = scanner.nextInt();
        }
        return opcao;
    }
}