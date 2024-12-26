package pansa.src;

import java.math.BigDecimal;

public class Zagueiro extends Jogador {

    public Zagueiro(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
            ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
    }

    @Override
    public BigDecimal calcularValorCompra() {
        BigDecimal valorBase = getPreco()
                .add(getPreco().multiply(BigDecimal.valueOf(getApetiteFinanceiro().getPercentual())));
        if (getIdade() > 30) {
            return valorBase.multiply(BigDecimal.valueOf(0.80));
        }
        return valorBase;
    }

    @Override
    public boolean temInteresseEmClube(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }
}
