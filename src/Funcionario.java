import java.util.Scanner;

public class Funcionario {
    private String nome;
    private String matricula;
    private String senha;
    //----------------------------------------------------------------------------
    public Funcionario(String nome, String matricula, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }
    //----------------------------------------------------------------------------
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void loginFuncionario() {
        Scanner scanner = new Scanner(System.in);
        int optionMenuFuncionario;
        System.out.println("1 - Registrar");
        System.out.println("2 - Login");
        System.out.println("3 - Voltar");
        System.out.println("Escolha uma opção: ");
        optionMenuFuncionario = scanner.nextInt();
        if (optionMenuFuncionario == 1) {
            registrarFuncionario();
        } else if (optionMenuFuncionario == 2) {
            logarFuncionario();
        } else if (optionMenuFuncionario == 3) {
            Utilitario.login();
        } else{
            System.out.println("\nOpção inválida, tente novamente");
            loginFuncionario();
        }
    }

    public static void registrarFuncionario() {
        Utilitario.pularLinhas();
        Scanner scanner = new Scanner(System.in);
        String nome;
        String matricula;
        String senha;
        System.out.println("Registrar funcionário");
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("Matrícula (somente números): ");
        matricula = scanner.nextLine();
        System.out.print("Senha: ");
        senha = scanner.nextLine();
        Funcionario newFuncionario = new Funcionario(nome, matricula, senha);
        DBSingleton.getDBSingleton().getFuncionarioList().add(newFuncionario);
        System.out.println("Funcionario registrado!");
        System.out.println("Faça o login no menu");
        Utilitario.pularLinhas();
        loginFuncionario();
    }

    public static void logarFuncionario() {
        Utilitario.pularLinhas();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login do funcionário");
        String matricula;
        String senha;
        boolean achou = false;
        System.out.print("Mátricula (somente números): ");
        matricula = scanner.nextLine();
        System.out.print("Senha: ");
        senha = scanner.nextLine();
        for (Funcionario funcionario : DBSingleton.getDBSingleton().getFuncionarioList()) {
            if (funcionario.getMatricula().equals(matricula) && funcionario.getSenha().equals(senha)) {
                System.out.println("Login realizado com sucesso!\n");
                achou = true;
                funcionarioLogado(funcionario.getNome());
            }
        }
        if (achou == false) {
            System.out.println("Cadastro não encotrado");
            Utilitario.pularLinhas();
            loginFuncionario();
        }
    }

    public static void funcionarioLogado(String nome){
        System.out.println("Bem vindo(a) "+nome+"!");
        menuFuncionarioLogado();
    }

    public static void menuFuncionarioLogado(){
        int optionFuncionarioLogado;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1 - Verificar Protocolos");
        System.out.println("2 - Atualizar Status do Protocolo");
        System.out.println("3 - Voltar ao menu inicial");
        System.out.print("Escolha uma opção: ");
        optionFuncionarioLogado = scanner.nextInt();
        switch (optionFuncionarioLogado){
            case 1:
                verificarProtocolos();
                break;
            case 2:
                atualizarStatusDoProtocolo();
                break;
            case 3:
                Utilitario.login();
                break;
            default:
                System.out.println("\nOpção inválida, tente novamente");
                menuFuncionarioLogado();
                break;
        }

    }

    public static void verificarProtocolos(){
        boolean achou;
        if(DBSingleton.getDBSingleton().getProtocoloList().isEmpty()) {
            System.out.println("\nNenhum protocolo registrado");
            menuFuncionarioLogado();
        } else {
            for (Protocolo protocolo : DBSingleton.getDBSingleton().getProtocoloList()) {
                System.out.println("--------------------------");
                System.out.printf("\nNúmero do protocolo: %d\n", protocolo.getNumeroProtocolo());
                System.out.print("Tipo do protocolo: ");
                switch (protocolo.getTipo()) {
                    case 1:
                        System.out.println("Poda de ârvore");
                        break;
                    case 2:
                        System.out.println("Asfaltamento na rua");
                        break;
                    case 3:
                        System.out.println("Conserto de iluminação pública");
                        break;
                    case 4:
                        System.out.println("Limpeza");
                        break;
                    case 5:
                        System.out.println("Saúde");
                        break;
                    case 6:
                        System.out.println("Segurança escolar");
                        break;
                    case 7:
                        System.out.println("Coleta de lixo");
                        break;
                }
                System.out.printf("Descrição do protocolo: %s\n", protocolo.getDescricao());
                System.out.printf(protocolo.getRua()+", "+protocolo.getNumero()+" - "+protocolo.getBairro()+", "+protocolo.getCep()+" - "+protocolo.getComplemento()+"\n");
                System.out.print("Status do protocolo: ");
                switch (protocolo.getStatus()) {
                    case 1:
                        System.out.println("Aberto");
                        break;
                    case 2:
                        System.out.println("Em triagem");
                        break;
                    case 3:
                        System.out.println("Em andamento");
                        break;
                    case 4:
                        System.out.println("Resolvido");
                        break;
                    case 5:
                        System.out.println("Reprovado");
                }
                System.out.println("--------------------------\n");
            }
            menuFuncionarioLogado();
        }
    }

    public static void atualizarStatusDoProtocolo(){
        Scanner scanner = new Scanner(System.in);
        boolean achou = false;
        Utilitario.pularLinhas();
        System.out.print("Digite o número do protocolo que será atualizado: ");
        int protocoloSolicitado = scanner.nextInt();
        if(DBSingleton.getDBSingleton().getProtocoloList().isEmpty() == false) {
            achou = true;
            for (Protocolo protocolo : DBSingleton.getDBSingleton().getProtocoloList()) {
                if (protocolo.getNumeroProtocolo() == protocoloSolicitado) {
                    System.out.print("Status atual do protocolo:");
                    switch (protocolo.getStatus()) {
                        case 1:
                            System.out.println("Aberto");
                            break;
                        case 2:
                            System.out.println("Em triagem");
                            break;
                        case 3:
                            System.out.println("Em andamento");
                            break;
                        case 4:
                            System.out.println("Resolvido");
                            break;
                        case 5:
                            System.out.println("Reprovado");
                    }

                    System.out.println("\n Novo status");

                    int optionTipoDeStatus;
                    System.out.println("Escolha o novo status desse protocolo: ");
                    System.out.println("1 - Aberto");
                    System.out.println("2 - Em triagem");
                    System.out.println("3 - Em andamento");
                    System.out.println("4 - Resolvido");
                    System.out.println("5 - Reprovado");
                    System.out.println("6 - Voltar");
                    System.out.print("Escolha uma opção: ");
                    optionTipoDeStatus = scanner.nextInt();
                    if (optionTipoDeStatus == 6){
                        menuFuncionarioLogado();
                    }
                    protocolo.setStatus(optionTipoDeStatus);
                    System.out.println("Status do protocolo atualizado com sucesso!");
                }
            }
        }
        if(achou == false){
            System.out.println("Número de protocolo não encontrado, você será redirecionado ao menu");
        }
        menuFuncionarioLogado();
    }
}


