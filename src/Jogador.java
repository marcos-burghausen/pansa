package pansa.src;

import java.math.BigDecimal;

public abstract class Jogador {
    private String nome;
    private int idade;
    private Clube clubeAtual;
    private int reputacaoHistorica;
    private ApetiteFinanceiro apetiteFinanceiro;
    private BigDecimal preco;

    public Jogador(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
            ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        this.nome = nome;
        this.idade = idade;
        this.clubeAtual = clubeAtual;
        this.reputacaoHistorica = reputacaoHistorica;
        this.apetiteFinanceiro = apetiteFinanceiro;
        this.preco = preco;
    }

    public String getNomeClube() {
        return clubeAtual != null ? clubeAtual.getNome() : "Sem Clube";
    }

    public abstract BigDecimal calcularValorCompra();

    public abstract boolean temInteresseEmClube(Clube clube);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Clube getClubeAtual() {
        return clubeAtual;
    }

    public void setClubeAtual(Clube clubeAtual) {
        this.clubeAtual = clubeAtual;
    }

    public int getReputacaoHistorica() {
        return reputacaoHistorica;
    }

    public void setReputacaoHistorica(int reputacaoHistorica) {
        this.reputacaoHistorica = reputacaoHistorica;
    }

    public ApetiteFinanceiro getApetiteFinanceiro() {
        return apetiteFinanceiro;
    }

    public void setApetiteFinanceiro(ApetiteFinanceiro apetiteFinanceiro) {
        this.apetiteFinanceiro = apetiteFinanceiro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
