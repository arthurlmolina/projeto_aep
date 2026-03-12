import java.util.List;

public class Utilitario {

    public int login(List<LoginCidadao> listaCidadao, List<LoginFuncionario> listaFuncionario){

        MenuService menu = new MenuService();
        CidadaoService cidadao = new CidadaoService();
        FuncionarioService funcionario = new FuncionarioService();

        int tipoUsuario = menu.escolherTipoUsuario();
        int acao = menu.escolherAcao();

        // CIDADÃO
        if(tipoUsuario == 1){

            if(acao == 1){
                cidadao.registrar(listaCidadao);
                return 5; // cadastro realizado
            }

            if(acao == 2){

                if(cidadao.login(listaCidadao)){
                    return 1;
                }else{
                    return 2;
                }

            }

        }

        // FUNCIONÁRIO
        if(tipoUsuario == 2){

            if(acao == 1){
                funcionario.registrar(listaFuncionario);
                return 5;
            }

            if(acao == 2){

                if(funcionario.login(listaFuncionario)){
                    return 3;
                }else{
                    return 4;
                }

            }

        }

        return -1;
    }
}