import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    int retorno;
        List<LoginCidadao> listaCidadao = new ArrayList<LoginCidadao>();
        List<LoginFuncionario> listaFuncionario = new ArrayList<LoginFuncionario>();

    Utilitario util = new Utilitario();
    retorno = util.login(listaCidadao, listaFuncionario);

    }
}