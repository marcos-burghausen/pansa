package pansa.src;

import java.math.BigDecimal;

public class Goleiro extends Jogador {
    private int penaltisDefendidos;

    public Goleiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
            ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int penaltisDefendidos) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.penaltisDefendidos = penaltisDefendidos;
    }

    @Override
    public BigDecimal calcularValorCompra() {
        BigDecimal valorBase = getPreco()
                .add(getPreco().multiply(BigDecimal.valueOf(getApetiteFinanceiro().getPercentual())));
        BigDecimal acrescimo = valorBase.multiply(BigDecimal.valueOf(0.04 * penaltisDefendidos));
        return valorBase.add(acrescimo);
    }

    @Override
    public boolean temInteresseEmClube(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }
}
