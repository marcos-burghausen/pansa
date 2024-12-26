package pansa.src;

import java.math.BigDecimal;

public class Lateral extends Jogador {
    private int cruzamentosCerteiros;

    public Lateral(String nome, int idade, Clube clubeAtual, int reputacaoHistorica,
            ApetiteFinanceiro apetiteFinanceiro, BigDecimal preco, int cruzamentosCerteiros) {
        super(nome, idade, clubeAtual, reputacaoHistorica, apetiteFinanceiro, preco);
        this.cruzamentosCerteiros = cruzamentosCerteiros;
    }

    @Override
    public BigDecimal calcularValorCompra() {
        BigDecimal valorBase = getPreco()
                .add(getPreco().multiply(BigDecimal.valueOf(getApetiteFinanceiro().getPercentual())));
        BigDecimal acrescimo = valorBase.multiply(BigDecimal.valueOf(0.02 * cruzamentosCerteiros));
        valorBase = valorBase.add(acrescimo);
        if (getIdade() > 28) {
            return valorBase.multiply(BigDecimal.valueOf(0.70));
        }
        return valorBase;
    }

    @Override
    public boolean temInteresseEmClube(Clube clube) {
        return clube.getReputacaoHistorica() >= 1;
    }
}
