import java.util.List;
import java.util.Scanner;

public class CidadaoService {

    Scanner scanner = new Scanner(System.in);

    public void registrar(List<LoginCidadao> lista){

        scanner.nextLine();

        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("CPF:");
        String cpf = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        LoginCidadao novo = new LoginCidadao(nome, cpf, senha);

        lista.add(novo);

        System.out.println("Cidadão registrado com sucesso!");
    }

    public boolean login(List<LoginCidadao> lista){

        System.out.println("CPF:");
        String cpf = scanner.next();

        System.out.println("Senha:");
        String senha = scanner.next();

        for(LoginCidadao c : lista){
            if(cpf.equals(c.getCpf()) && senha.equals(c.getSenha())){
                return true;
            }
        }
        return false;
    }
}