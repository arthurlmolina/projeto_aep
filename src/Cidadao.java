import java.util.Random;
import java.util.Scanner;

public class Cidadao {
    private String nome;
    private String cpf;
    private String senha;

    //----------------------------------------------------------------------------
    public Cidadao(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    //----------------------------------------------------------------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    //----------------------------------------------------------------------------

    public static void loginCidadao() {
        Scanner scanner = new Scanner(System.in);
        int optionMenuCidadao;
        System.out.println("1 - Registrar");
        System.out.println("2 - Login");
        System.out.println("3 - Voltar");
        System.out.println("Escolha uma opção: ");
        optionMenuCidadao = scanner.nextInt();
        if (optionMenuCidadao == 1) {
            registrarCidadao();
        } else if (optionMenuCidadao == 2) {
            logarCidadao();
        } else if (optionMenuCidadao == 3) {
            Utilitario.login();
        }
    }

    public static void registrarCidadao() {
        Utilitario.pularLinhas();
        Scanner scanner = new Scanner(System.in);
        String nome;
        String cpf;
        String senha;
        System.out.println("Registrar cidadão");
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("Cpf (somente números): ");
        cpf = scanner.nextLine();
        //cpf = Utilitario.arrumarCpf(cpf);
        System.out.print("Senha: ");
        senha = scanner.nextLine();
        Cidadao newCidadao = new Cidadao(nome, cpf, senha);
        DBSingleton.getDBSingleton().getCidadaoList().add(newCidadao);
        System.out.println("Cidadão registrado!");
        System.out.println("Faça o login no menu");
        Utilitario.pularLinhas();
        loginCidadao();
    }

    public static void logarCidadao() {
        Utilitario.pularLinhas();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login do cidadão");
        String cpf;
        String senha;
        boolean achou = false;
        System.out.print("Cpf (somente números): ");
        cpf = scanner.nextLine();
        System.out.print("Senha: ");
        senha = scanner.nextLine();
        for (Cidadao cidadao : DBSingleton.getDBSingleton().getCidadaoList()) {
            if (cidadao.getCpf().equals(cpf) && cidadao.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!\n");
                achou = true;
                cidadaoLogado(cidadao.getNome());
            }
        }
        if (achou == false) {
            System.out.println("Cadastro não encotrado");
            Utilitario.pularLinhas();
            loginCidadao();
        }
    }

    public static void cidadaoLogado(String nome){
        System.out.println("Bem vindo(a) "+nome+"!");
        menuCidadaoLogado();
    }

    public static void menuCidadaoLogado(){
        int optionCidadaoLogado;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1 - Solicitar serviço");
        System.out.println("2 - Verificar status do protocolo");
        System.out.println("3 - Voltar ao menu inicial");
        System.out.print("Escolha uma opção: ");
        optionCidadaoLogado = scanner.nextInt();
        switch (optionCidadaoLogado){
            case 1:
                solicitarServico();
                break;
            case 2:
                verificarStatusDoProcolo();
                break;
            case 3:
                Utilitario.login();
                break;
            default:
                System.out.println("Opção inválida, tente novamente");
                menuCidadaoLogado();
                break;
        }

    }

    public static void solicitarServico(){
        Utilitario.pularLinhas();
        Random geradorDeNumeroDeProtocolo = new Random();
        int numeroProtocolo = geradorDeNumeroDeProtocolo.nextInt(1000000000);
        int optionTipoDeSolicitacao;
        String descricao;
        String cep;
        String rua;
        int numero;
        String bairro;
        String complemento;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos de solicitações");
        System.out.println("1 - Poda de arvore");
        System.out.println("2 - Asfaltamento na rua");
        System.out.println("3 - Conserto de iluminação pública");
        System.out.println("4 - Limpeza");
        System.out.println("5 - Saúde");
        System.out.println("6 - Segurança escolar");
        System.out.println("7 - Coleta de lixo");
        System.out.println("8 - Voltar");
        System.out.print("Escolha uma opção: ");
        optionTipoDeSolicitacao = scanner.nextInt();
        if (optionTipoDeSolicitacao == 8){
            menuCidadaoLogado();
        }
        scanner.nextLine(); // limpar o buffer
        System.out.println("\nDescrição da solicitação: ");
        descricao = scanner.nextLine();
        System.out.println("Preencha o endereço do local da solicitação");
        System.out.print("Cep: ");
        cep = scanner.nextLine();
        System.out.print("Rua: ");
        rua = scanner.nextLine();
        System.out.print("Número: ");
        numero = scanner.nextInt();
        scanner.nextLine(); //limpar o buffer
        System.out.print("Bairro: ");
        bairro = scanner.nextLine();
        System.out.print("Complemento: ");
        complemento = scanner.nextLine();

        Protocolo newProtocolo = new Protocolo(numeroProtocolo,optionTipoDeSolicitacao,descricao,cep,rua,numero,bairro,complemento);
        DBSingleton.getDBSingleton().getProtocoloList().add(newProtocolo);
        System.out.println("Solicitação concluída!");
        System.out.printf("GUARDE O NÚMERO DO PROTOCOLO (ele será necessária para a consulta do status do protocolo): %d\n", newProtocolo.getNumeroProtocolo());
        Utilitario.pularLinhas();
        menuCidadaoLogado();
    }

    public static void verificarStatusDoProcolo(){

    }
}

