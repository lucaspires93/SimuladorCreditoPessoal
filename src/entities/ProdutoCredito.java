package entities;

public abstract class ProdutoCredito {

    private Double valorSolicitado;
    private Integer numeroParcelas;
    private Integer jurosAnual;

    public ProdutoCredito(){
    }

    public ProdutoCredito(Double valorSolicitado, Integer numeroParcelas, Integer jurosAnual) {
        this.valorSolicitado = valorSolicitado;
        this.numeroParcelas = numeroParcelas;
        this.jurosAnual = jurosAnual;
    }

    public Double getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(Double valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getJurosAnual() {
        return jurosAnual;
    }

    public void setJurosAnual(Integer jurosAnual) {
        this.jurosAnual = jurosAnual;
    }

    public abstract double calcularParcelas();

    public abstract String exibirResumo();

    public abstract double totalPagar();

    public abstract double juroTotal();

    public abstract double valorParcelado();
}
