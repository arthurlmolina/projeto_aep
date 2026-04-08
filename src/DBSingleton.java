import java.util.ArrayList;
import java.util.List;

public final class DBSingleton {
    private List<Cidadao> cidadaoList;
    private List<Funcionario> funcionarioList;
    private List<Protocolo> protocoloList;
    private static DBSingleton dbSingleton;

    public static DBSingleton getDBSingleton(){
        if (dbSingleton == null) {
            dbSingleton = new DBSingleton();
        }
        return dbSingleton;
    }


    private DBSingleton() {
        this.cidadaoList = new ArrayList<>();
        this.funcionarioList = new ArrayList<>();
        this.protocoloList = new ArrayList<>();
    }

    public List<Cidadao> getCidadaoList() {
        return cidadaoList;
    }
    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }
    public List<Protocolo> getProtocoloList() {
        return protocoloList;
    }


}
