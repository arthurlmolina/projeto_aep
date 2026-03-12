import java.util.List;
import java.util.Scanner;

public class FuncionarioService {

    Scanner scanner = new Scanner(System.in);

    public void registrar(List<LoginFuncionario> lista){

        scanner.nextLine();

        System.out.println("Matrícula:");
        String matricula = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        LoginFuncionario novo = new LoginFuncionario(matricula, senha);

        lista.add(novo);

        System.out.println("Funcionário registrado!");
    }

    public boolean login(List<LoginFuncionario> lista){

        scanner.nextLine();

        System.out.println("Matrícula:");
        String matricula = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        for(LoginFuncionario f : lista){

            if(matricula.equals(f.getMatricula()) && senha.equals(f.getSenha())){
                return true;
            }
        }
        return false;
    }
}