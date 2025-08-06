package entities;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private Integer idade;

    public Pessoa(){
    }

    public Pessoa(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public abstract String exibirInfo();

    public boolean validarCPF(String cpf){
        return cpf != null && cpf.length() == 11;
    }
}
