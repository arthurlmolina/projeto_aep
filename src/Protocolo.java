public class Protocolo {
    private int numeroProtocolo;
    private int tipo;
    private String descricao;
    //localização
    private String cep;
    private String rua;
    private int numero;
    private String bairro;
    private String complemento;
    private int status;
//   1 - aberto
//   2 - triagem
//   3 - em execução
//   4 - resolvido
//   5 - encerrado

    //----------------------------------------------------------------------------


    public Protocolo(int numeroProtocolo, int tipo, String descricao, String cep, String rua, int numero, String bairro, String complemento) {
        this.numeroProtocolo = numeroProtocolo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.status=1;
    }

    public int getNumeroProtocolo() {
        return numeroProtocolo;
    }

    public void setNumeroProtocolo(int numeroProtocolo) {
        this.numeroProtocolo = numeroProtocolo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
