import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<LoginCidadao> listaCidadao = new ArrayList<>();
        List<LoginFuncionario> listaFuncionario = new ArrayList<>();
        List<Protocolo> listaProtocolo = new ArrayList<>();

        Utilitario util = new Utilitario();
        ProtocoloService protocoloService = new ProtocoloService();

        Scanner scanner = new Scanner(System.in);

        int retorno;

        while(true){

            retorno = util.login(listaCidadao, listaFuncionario);

            // CIDADÃO LOGADO
            if(retorno == 1){

                int menuCidadao = -1;

                while(menuCidadao != 0){
                    System.out.println("\nMENU DO CIDADÃO");
                    System.out.println("1 - Criar protocolo");
                    System.out.println("2 - Listar protocolos");
                    System.out.println("0 - Logout");

                    menuCidadao = scanner.nextInt();

                    if(menuCidadao == 1){
                        protocoloService.criarProtocolo(listaProtocolo);
                    }
                    if(menuCidadao == 2){
                        protocoloService.listarProtocolos(listaProtocolo);
                    }
                }
                System.out.println("Logout realizado.\n");
            }

            // LOGIN CIDADÃO INCORRETO
            if(retorno == 2){
                System.out.println("Login de cidadão inválido.");
            }

            // FUNCIONÁRIO LOGADO
            if(retorno == 3){

                int menuFuncionario = -1;

                while(menuFuncionario != 0){
                    System.out.println("\nMENU DO FUNCIONÁRIO");
                    System.out.println("1 - Listar protocolos");
                    System.out.println("0 - Logout");

                    menuFuncionario = scanner.nextInt();

                    if(menuFuncionario == 1){
                        protocoloService.listarProtocolos(listaProtocolo);
                    }
                }

                System.out.println("Logout realizado.\n");
            }

            // LOGIN FUNCIONÁRIO INCORRETO
            if(retorno == 4){
                System.out.println("Login de funcionário inválido.");
            }
            // CADASTRO REALIZADO
            if(retorno == 5){
                System.out.println("Cadastro realizado! Agora faça login.");
            }

        }
    }
}