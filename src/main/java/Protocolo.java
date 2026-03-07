public class Protocolo {
    private int tipo;
    private String descricao;
    //localização
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String opcional;

    //----------------------------------------------------------------------------
    public Protocolo(int tipo, String descricao, String cep, String endereco, int numero, String bairro, String opcional) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.opcional = opcional;
    }
    //----------------------------------------------------------------------------
    //getters
    public int getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getOpcional() {
        return opcional;
    }

    //setters
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setOpcional(String opcional) {
        this.opcional = opcional;
    }
}
