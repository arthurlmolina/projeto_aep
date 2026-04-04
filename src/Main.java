import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cidadao> listaCidadao = new ArrayList<>();
        List<Funcionario> listaFuncionario = new ArrayList<>();
        List<Protocolo> listaProtocolo = new ArrayList<>();

        Utilitario.login(listaCidadao, listaFuncionario, listaProtocolo);

    }
}