package desafiodiobanco;

public class Cliente {

    private String nome;
    private String email;
    private long cpf;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}