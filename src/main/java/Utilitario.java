import java.util.List;
import java.util.Scanner;

public class Utilitario {
    private int opcao;
    Scanner scanner = new Scanner(System.in);
    private boolean loginValido;
    //cidadão
    private String nomeCidadao;
    private String cpfCidadao;
    private String senhaCidadao;

    private String matriculaFuncionario;
    private String senhaFuncionario;

    public Utilitario(){};

    public int login(List<LoginCidadao> listaCidadao, List<LoginFuncionario> listaFuncionario) {
        //return 1 cidadão logado
        //return 2 cidadão login não encontrado
        //return 3 funcionário logado
        //return 4 funcionário login não encontrado

        System.out.println("Bem vindo(a) ao sistema municipal de requisições de serviços públicos!");
        while(opcao > 2 || opcao < 1) {
            System.out.println("Escolha seu tipo de login:");
            System.out.println("1 - Cidadão");
            System.out.println("2 - Funcionário");
            System.out.println("Opção: ");
            opcao = scanner.nextInt();
            if(opcao != 1 && opcao!= 2){
                System.out.println("opção inválida, tente novamente");
                pularLinhas();
            }
        }
        switch (opcao) {
            case 1: //cidadão
                do {
                    System.out.println("Escolha uma opção");
                    System.out.println("1 - Registrar");
                    System.out.println("2 - Login");
                    System.out.println("Opção: ");
                    opcao = scanner.nextInt();
                    if(opcao != 1 && opcao!= 2){
                        System.out.println("opção inválida, tente novamente");
                        pularLinhas();
                    }
                } while(opcao > 2 || opcao < 1);  // fim while

                switch (opcao) {
                    case 1: // registrar novo cidadao
                        System.out.println("Registrar cidadão");
                        System.out.println("Nome: ");
                        nomeCidadao = scanner.nextLine();
                        System.out.println("Cpf: ");
                        cpfCidadao = scanner.nextLine();
                        System.out.println("Senha: ");
                        senhaCidadao = scanner.nextLine();
                        LoginCidadao newCidadao = new LoginCidadao(nomeCidadao, cpfCidadao, senhaCidadao);
                        listaCidadao.add(newCidadao);
                        System.out.println("Cidadão registrado com sucesso!");
                        return 1; // cidadão logado
                    case 2: // logar novo cidadão
                        while(true){
                            loginValido = false;
                            System.out.println("Digite seu cpf: ");
                            System.out.println("Cpf");
                            cpfCidadao = scanner.next();
                            System.out.println("Digite sua senha: ");
                            System.out.println("Senha: ");
                            senhaCidadao = scanner.next();

                            for (LoginCidadao cidadao : listaCidadao) {
                                if (cpfCidadao.equals(cidadao.getCpf()) && senhaCidadao.equals(cidadao.getSenha()) ) {
                                        loginValido = true;
                                        break;
                                }
                            }
                            if(loginValido){
                                return 1;
                            } else{
                                System.out.println("Login incorreto, tente novamente");
                                pularLinhas();
                                return 2;
                            }
                        }
                }//fim 2° switch case
                    break; // break 1° switch case

            case 2: //funcionario
                do{
                    System.out.println("Escolha uma opção");
                    System.out.println("1 - Registrar");
                    System.out.println("2 - Login");
                    System.out.println("Opção: ");
                    opcao = scanner.nextInt();
                    if(opcao != 1 && opcao!= 2){
                        System.out.println("opção inválida, tente novamente");
                        pularLinhas();
                    }
                }while(opcao > 2 || opcao < 1); //fim while
                switch (opcao) {
                    case 1:
                        System.out.println("Registrar funcionário");
                        System.out.println("Matrícula");
                        matriculaFuncionario = scanner.nextLine();
                        System.out.println("Senha: ");
                        senhaFuncionario = scanner.nextLine();
                        LoginFuncionario newFuncionario = new LoginFuncionario(matriculaFuncionario, senhaFuncionario);
                        listaFuncionario.add(newFuncionario);
                        System.out.println("Funcionário registrado com sucesso");
                        pularLinhas();
                        return 3; // funcionário logado
                    case 2: //login funcionario
                        while(true){
                            loginValido = false;
                            System.out.println("Digite sua mátricula: ");
                            System.out.println("Matrícula");
                            matriculaFuncionario = scanner.nextLine();
                            System.out.println("Digite sua senha: ");
                            System.out.println("Senha: ");
                            senhaFuncionario = scanner.nextLine();
                            for (LoginFuncionario funcionario : listaFuncionario) {
                                if (matriculaFuncionario.equals(funcionario.getMatricula()) && senhaFuncionario.equals(funcionario.getSenha()) ){
                                        loginValido = true;
                                        break;
                                    }
                            }
                            if(loginValido){
                                return 3;
                            }else {
                                pularLinhas();
                                return 4;
                            }
                        }


                } //fim 2° switch case
                break;

            default:
                System.out.println("opção inválida, tente novamente");
        }//fim 1° switch case
        return -1;
    }// fim login()

    public void pularLinhas(){
        System.out.println("\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n\n\n\n\n\n\n\n\n\n\n");
    }

}//fim classe

