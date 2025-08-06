package entities;

;

public class CreditoPessoal extends ProdutoCredito{

    private Cliente cliente;


    public CreditoPessoal(Double valorSolicitado, Integer numeroParcelas, Integer jurosAnual,Cliente cliente) {
        super(valorSolicitado, numeroParcelas, jurosAnual);
        this.cliente = cliente;
    }

    public String aprovacao(){
        if(getValorSolicitado() > totalPagar()){
            return "Solicitação : APROVADA!";
        }
        else return "Solicitação : NÃO APROVADA!";
    }
    @Override
    public double totalPagar(){
      return getValorSolicitado() * (1 + getJurosAnual() / 100.0);
    }

    @Override
    public double calcularParcelas() {
        return getValorSolicitado() * (1 + getJurosAnual()/100.0)/ getNumeroParcelas();
    }

    @Override
    public double juroTotal(){
        return totalPagar() - getValorSolicitado();
    }
    @Override
    public double valorParcelado(){
        return totalPagar() / getNumeroParcelas();
    }
    @Override
    public String exibirResumo() {
        return "Salário Mensal: R$ "+ String.format("%.2f",cliente.getSalarioMensal())+ "\n"
                + "Score de Crédito: "+ cliente.getScoreCredito()+ "\n"
                + "Limite de Crédito: R$ "+ String.format("%.2f",cliente.getLimiteCreditoDisponivel())+ "\n"
                + "\n"
                + "--- RESUMO DO EMPRÉSTIMO ---"+ "\n"
                + "Valor solicitado: R$ "+ String.format("%.2f",getValorSolicitado())+ "\n"
                + "Parcelado em: "+ getNumeroParcelas()+"x de R$"+ String.format("%.2f",valorParcelado())+ "\n"
                + "Total com juros: R$"+String.format("%.2f",totalPagar());
    }
}
