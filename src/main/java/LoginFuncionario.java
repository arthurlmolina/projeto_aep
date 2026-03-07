public class LoginFuncionario {
    private String matricula;
    private String senha;
    //----------------------------------------------------------------------------
    public LoginFuncionario(String matricula, String senha) {
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
}
