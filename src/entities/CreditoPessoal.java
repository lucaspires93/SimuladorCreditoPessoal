package entities;

;

public class CreditoPessoal extends ProdutoCredito{

    private Cliente cliente;


    public CreditoPessoal(Double valorSolicitado, Integer numeroParcelas, Integer jurosAnual,Cliente cliente) {
        super(valorSolicitado, numeroParcelas, jurosAnual);
        this.cliente = cliente;
    }

    public String aprovacao(){
        if(getValorSolicitado() <= cliente.getLimiteCreditoDisponivel()){
            return "Solicitação : APROVADA!";
        }
        else {return "Solicitação : NÃO APROVADA!";}
    }
    @Override
    public double totalPagar(){
        if (getNumeroParcelas() <= 0) {
            throw new IllegalArgumentException("Quantidade de parcelas deve ser maior que zero.");
        }

        double jurosAnual = getJurosAnual() / 100.0;
        double jurosMensal = Math.pow(1 + jurosAnual, 1.0 / 12) - 1;

        double total = getValorSolicitado() * Math.pow(1 + jurosMensal, getNumeroParcelas());

        return total;
    }

    @Override
    public double calcularParcelas() {
        return totalPagar() / getNumeroParcelas();
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
