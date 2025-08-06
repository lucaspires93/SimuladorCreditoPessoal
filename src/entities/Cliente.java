package entities;


public class Cliente extends Pessoa{

    private Double salarioMensal;
    private Integer scoreCredito;
    private Double limiteCreditoDisponivel;

    public Cliente(){
    }

    public Cliente(String nome, String cpf, Integer idade, Double salarioMensal, Integer scoreCredito, Double limiteCreditoDisponivel) {
        super(nome, cpf, idade);
        this.salarioMensal = salarioMensal;
        this.scoreCredito = scoreCredito;
        this.limiteCreditoDisponivel = limiteCreditoDisponivel;
    }

    public Double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(Double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public Integer getScoreCredito() {
        return scoreCredito;
    }

    public void setScoreCredito(Integer scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

    public Double getLimiteCreditoDisponivel() {
        return limiteCreditoDisponivel;
    }

    public void setLimiteCreditoDisponivel(Double limiteCreditoDisponivel) {
        this.limiteCreditoDisponivel = limiteCreditoDisponivel;
    }

    @Override
    public String exibirInfo() {
       return "Nome : " + getNome()+ "\n"
                + "Idade: "+ getIdade();
    }

    public double calcularLimiteCredito(){
        double fator;
        if (scoreCredito < 300){
            fator = 0.5;
        } else if (getScoreCredito() <= 600) {
            fator = 1.0;
        } else if (getScoreCredito() <= 800) {
            fator = 1.5;
        } else
            fator = 2.0;

        double limiteCreditoDisponivel = salarioMensal * 2 * fator;

        return limiteCreditoDisponivel;
    }


}
